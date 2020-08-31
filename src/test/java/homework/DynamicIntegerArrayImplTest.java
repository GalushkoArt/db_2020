package homework;

import org.junit.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.*;

public class DynamicIntegerArrayImplTest {

    @Test
    public void addTest() {
        DynamicIntegerArray dynamicIntegerArray = new DynamicIntegerArrayImpl();
        final int TEST_SIZE = 1_000_000;
        final Random RANDOM = new Random(System.currentTimeMillis());

        for (int i = 0; i < TEST_SIZE; i++) {
            dynamicIntegerArray.add(RANDOM.nextInt());
        }

        assertThat(dynamicIntegerArray.size()).isEqualTo(TEST_SIZE);
    }

    @Test
    public void getTest() {
        DynamicIntegerArray dynamicIntegerArray = new DynamicIntegerArrayImpl();
        final int FIRST_VALUE = 12,
                SECOND_VALUE = 0,
                THIRD_VALUE = -1235432;

        dynamicIntegerArray.add(FIRST_VALUE);
        dynamicIntegerArray.add(SECOND_VALUE);
        dynamicIntegerArray.add(THIRD_VALUE);

        assertThat(dynamicIntegerArray.get(0)).isEqualTo(FIRST_VALUE);
        assertThat(dynamicIntegerArray.get(1)).isEqualTo(SECOND_VALUE);
        assertThat(dynamicIntegerArray.get(2)).isEqualTo(THIRD_VALUE);
        assertThatThrownBy(() -> dynamicIntegerArray.get(4)).isInstanceOf(IndexOutOfBoundsException.class);
        assertThatThrownBy(() -> dynamicIntegerArray.get(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void sizeTest() {
        DynamicIntegerArray dynamicIntegerArray = new DynamicIntegerArrayImpl(0);
        final int RANDOM_VALUE = new Random().nextInt();
        final int RANDOM_SIZE = new Random().nextInt(1_000_000);

        assertThat(dynamicIntegerArray.size()).isZero();

        dynamicIntegerArray.add(RANDOM_VALUE);

        assertThat(dynamicIntegerArray.size()).isOne();

        for (int i = 0; i < RANDOM_SIZE; i++) {
            dynamicIntegerArray.add(RANDOM_VALUE);
        }

        assertThat(dynamicIntegerArray.size()).isEqualTo(RANDOM_SIZE + 1);
    }
}
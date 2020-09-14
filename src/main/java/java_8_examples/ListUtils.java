package java_8_examples;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author Evgeny Borisov
 */
public class ListUtils {
    public static <T, R> int countDuplicates(List<T> list, T t, BiFunction<T, T, Boolean> equaler) {
        int counter=0;
        for (T t1 : list) {
            if (equaler.apply(t1,t)) {
                counter++;
            }
        }
        return counter;
    }
}

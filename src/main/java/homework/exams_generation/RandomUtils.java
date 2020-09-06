package homework.exams_generation;

import org.apache.commons.math3.random.RandomDataGenerator;

import java.util.Random;

public class RandomUtils {
    private static RandomDataGenerator random = new RandomDataGenerator();

    public static int getInteger() {
        return random.nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static int getIntegerUpTo(int max) {
        return random.nextInt(0, max);
    }

    public static int getIntegerInRange(int min, int max) {
        return random.nextInt(min, max);
    }

    public static double getDouble() {
        return random.nextUniform(-1, 1, true);
    }

    public static double getDoubleUpTo(double max) {
        return random.nextUniform(0, max);
    }

    public static double getDoubleInRange(double min, double max) {
        return random.nextUniform(min, max, true);
    }
}

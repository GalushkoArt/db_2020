package homework.exams_generation.generators;

import homework.exams_generation.RandomUtils;

public class SimpleStrategy implements ExerciseStrategy {
    @Override
    public double getA(Generator generator) {
        return RandomUtils.getIntegerInRange((int) generator.getAMin(),(int) generator.getAMax());
    }

    @Override
    public double getB(Generator generator) {
        return RandomUtils.getIntegerInRange((int) generator.getBMin(),(int) generator.getBMax());
    }
}

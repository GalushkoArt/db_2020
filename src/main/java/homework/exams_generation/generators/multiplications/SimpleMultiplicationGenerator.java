package homework.exams_generation.generators.multiplications;

import homework.exams_generation.generators.SimpleStrategy;

public class SimpleMultiplicationGenerator extends MultiplicationGenerator {
    public SimpleMultiplicationGenerator() {
        super(1, 10, 1, 10, new SimpleStrategy());
    }
}

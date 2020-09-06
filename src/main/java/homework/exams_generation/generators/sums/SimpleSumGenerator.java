package homework.exams_generation.generators.sums;

import homework.exams_generation.generators.SimpleStrategy;

public class SimpleSumGenerator extends SumGenerator {
    public SimpleSumGenerator() {
        super(1, 100, 1, 100, new SimpleStrategy());
    }
}

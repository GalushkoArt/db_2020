package homework.exams_generation.generators.divisions;

import homework.exams_generation.generators.SimpleStrategy;

public class SimpleDivisionGenerator extends DivisionGenerator {
    public SimpleDivisionGenerator() {
        super(1, 100, 1, 10, new SimpleStrategy());
    }
}

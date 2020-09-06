package homework.exams_generation.generators.subtractions;

import homework.exams_generation.generators.SimpleStrategy;

public class SimpleSubtractionGenerator extends SubtractionGenerator {
    public SimpleSubtractionGenerator() {
        super(1, 40, 1, 40, new SimpleStrategy());
    }


}

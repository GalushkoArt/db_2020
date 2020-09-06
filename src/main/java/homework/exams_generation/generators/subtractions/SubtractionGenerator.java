package homework.exams_generation.generators.subtractions;

import homework.exams_generation.Operator;
import homework.exams_generation.generators.ExerciseStrategy;
import homework.exams_generation.generators.Generator;

public class SubtractionGenerator extends Generator {
    public SubtractionGenerator(double aMin, double aMax, double bMin, double bMax, ExerciseStrategy strategy) {
        super(Operator.MINUS, 1E-5, aMin, aMax, bMin, bMax, strategy);
    }

    @Override
    public double getAnswer(double a, double b) {
        return a-b;
    }
}

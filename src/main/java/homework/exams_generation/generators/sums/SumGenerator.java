package homework.exams_generation.generators.sums;

import homework.exams_generation.Operator;
import homework.exams_generation.generators.ExerciseStrategy;
import homework.exams_generation.generators.Generator;

public class SumGenerator extends Generator {
    public SumGenerator(double aMin, double aMax, double bMin, double bMax, ExerciseStrategy strategy) {
        super(Operator.PLUS, 1E-5, aMin, aMax, bMin, bMax, strategy);
    }

    @Override
    public double getAnswer(double a, double b) {
        return a+b;
    }
}

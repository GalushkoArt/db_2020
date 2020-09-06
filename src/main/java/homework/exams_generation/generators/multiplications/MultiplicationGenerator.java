package homework.exams_generation.generators.multiplications;

import homework.exams_generation.Operator;
import homework.exams_generation.generators.ExerciseStrategy;
import homework.exams_generation.generators.Generator;

public class MultiplicationGenerator extends Generator {
    public MultiplicationGenerator(double aMin, double aMax, double bMin, double bMax, ExerciseStrategy strategy) {
        super(Operator.MULTIPLY, 1E-5, aMin, aMax, bMin, bMax, strategy);
    }

    @Override
    public double getAnswer(double a, double b) {
        return a*b;
    }
}

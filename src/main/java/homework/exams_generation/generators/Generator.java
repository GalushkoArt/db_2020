package homework.exams_generation.generators;

import homework.exams_generation.Exercise;
import homework.exams_generation.Operator;
import homework.exams_generation.RandomUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class Generator {
    private final Operator operator;
    private final double sigma;
    private final double aMin;
    private final double aMax;
    private final double bMin;
    private final double bMax;
    private final ExerciseStrategy strategy;

    public abstract double getAnswer(double a, double b);

    public double getA() {
        return strategy.getA(this);
    }

    public double getB() {
        return strategy.getB(this);
    }

    public Exercise getExercise() {
        double a = getA();
        double b = getB();
        return Exercise.builder()
                .a(a)
                .b(b)
                .operator(getOperator())
                .answer(getAnswer(a, b))
                .sigma(getSigma())
                .build();
    }
}

package homework.exams_generation;

import homework.exams_generation.generators.Generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Evgeny Borisov
 */
public class Examinator {
    private final List<Generator> generators;

    public Examinator(Generator... generators) {
        this.generators = new ArrayList<>(Arrays.asList(generators));
    }

    public List<Exercise> generate(int amount) {
        ArrayList<Exercise> exercises = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            exercises.add(generators.get(RandomUtils.getIntegerUpTo(generators.size()-1)).getExercise());
        }
        return exercises;
    }
}

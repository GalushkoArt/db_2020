package homework.exams_generation;

import homework.exams_generation.generators.multiplications.SimpleMultiplicationGenerator;
import homework.exams_generation.generators.sums.SimpleSumGenerator;

import java.util.List;
import java.util.Scanner;

public class ExamsMain {
    public static void main(String[] args) {
        Examinator examinator = new Examinator(new SimpleMultiplicationGenerator(), new SimpleSumGenerator());
        List<Exercise> exercises = examinator.generate(5);
        exam(exercises);
    }

    public static void exam(List<Exercise> exercises) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;

        System.out.println("Решите следующие примеры");
        for (Exercise exercise: exercises) {
            System.out.println(exercise);
            Double answer;
            while (true) {
                try {
                    answer = Double.parseDouble(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Пожалуйста введите число!");
                }
            }
            Double exerciseAnswer = exercise.getAnswer(), sigma = exercise.getSigma();
            if (answer.compareTo(exerciseAnswer-sigma)>= 0 &&  answer.compareTo(exerciseAnswer+sigma) <= 0) {
                System.out.println("Верно");
                count++;
            } else {
                System.out.println("Неверно. Ответ: " + exerciseAnswer);
            }
        }
        System.out.println(count + " правильных ответов");
        scanner.close();
    }
}

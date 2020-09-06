package homework.exams_generation;

import java.util.Scanner;

public class StringUtils {
    public static String askString() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        return str;
    }
}

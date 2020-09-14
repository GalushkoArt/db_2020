package java_8_examples;

import java.nio.file.Path;

public class YesterdayMain {
    public static void main(String[] args) {
        Path yesterdayFile = Path.of("data/yest.txt");
        System.out.println(FileStringUtils.numberOfWordsInFile(yesterdayFile));
        FileStringUtils.mapOfWordsInFile(yesterdayFile).entrySet().forEach(System.out::println);
        System.out.println(FileStringUtils.mostPopularWordInFile(yesterdayFile));
        Friday13Service.printMap(1910, 1915);
    }
}

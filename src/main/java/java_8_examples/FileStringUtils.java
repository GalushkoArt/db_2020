package java_8_examples;

import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileStringUtils {
    public static long numberOfWordsInFile(Path path) {
        return streamOfWords(path).count();
    }

    public static Map<String, Integer> mapOfWordsInFile(Path path) {
        return streamOfWords(path)
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)));
    }

    public static String mostPopularWordInFile(Path path) {
        return mapOfWordsInFile(path).entrySet().stream()
                .max(Comparator.comparingInt(Map.Entry::getValue))
                .orElseThrow()
                .getKey();
    }

    @SneakyThrows
    public static Stream<String> streamOfWords(Path path) {
        return Files.readAllLines(path).stream()
                .flatMap(line -> Arrays.stream(line.split("[,\\. ]+").clone()))
                .filter(word -> !word.isEmpty());
    }
}

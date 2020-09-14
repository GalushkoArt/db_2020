package java_8_examples;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Evgeny Borisov
 */
public class Friday13Service {
    public static void printMap(int startYear, int endYear) {
        Stream.iterate(LocalDate.of(startYear, 1, 13), date -> date.plusMonths(1))
                .limit((endYear-startYear+1)*12)
                .filter(date -> date.getDayOfWeek().equals(DayOfWeek.FRIDAY))
                .map(LocalDate::getYear)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)))
                .entrySet()
                .forEach(System.out::println);
        //1913 - 3
        //1917 - 3
        //1918 - 3
        //1903 - 2
        //1904 - 2
        //1901 - 1
    }
}

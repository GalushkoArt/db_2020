package date_time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

/**
 * @author Evgeny Borisov
 */
public class Main {


    public Date convert(LocalDate date) {
        return Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public LocalDateTime convert(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

        // 1981/02/30&18:20
    public static int daysBetween(String firstDate, String lastDate) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd&HH:mm");
        LocalDateTime start = LocalDateTime.parse(firstDate, dtf);
        LocalDateTime end = LocalDateTime.parse(lastDate, dtf);
        return (int) Duration.between(start, end).toDays();
    }



    public static void main(String[] args) {



        LocalTime now1 = LocalTime.now();
//        LocalDateTime.of(1932,12,12,12,12,12)
        LocalDate now = LocalDate.now();
        LocalDate yest = now.minusDays(1);
        LocalDate date = now.withYear(2010);
        String displayName = date.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
        System.out.println("displayName = " + displayName);

//        Duration
        long between = ChronoUnit.DAYS.between(date, now);
        System.out.println("between = " + between);

//
//        String str = "java";
//        str = str.toUpperCase();
//
//        Date date = new Date();
//        System.out.println("date = " + date.getYear());
    }
}

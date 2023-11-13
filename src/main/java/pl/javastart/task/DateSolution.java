package pl.javastart.task;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;


public class DateSolution {
    static final List<String> FORMATTER_WITH_TIME = List.of("yyyy-MM-dd HH:mm:ss", "dd.MM.yyyy HH:mm:ss");
    static final List<String> FORMATTER_WITHOUT_TIME = List.of("yyyy-MM-dd");

    public static ZonedDateTime returnDateWithTime(String date) {
        LocalDateTime localDateTime = null;

        for (String s : FORMATTER_WITH_TIME) {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(s);
            try {
                localDateTime = LocalDateTime.parse(date, dateFormatter);
                return localDateTime.atZone(ZoneId.systemDefault());
            } catch (DateTimeParseException e) {
                //nop
            }
        }
        return null;
    }

    public static ZonedDateTime returnDateWithoutTime(String date) {
        for (String s : FORMATTER_WITHOUT_TIME) {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(s);
            try {
                LocalDate localDate = LocalDate.parse(date, dateFormatter);
                return LocalDateTime.of(localDate, LocalTime.MIDNIGHT).atZone(ZoneId.systemDefault());
            } catch (DateTimeParseException e) {
                //nop
            }
        }
        return null;
    }

    public static ZonedDateTime returnDate(String date) {
        ZonedDateTime zonedDateTime = returnDateWithTime(date);
        if (zonedDateTime == null) {
            zonedDateTime = returnDateWithoutTime(date);
        }
        return zonedDateTime;
    }

    public static String formatCorrectTime(ZonedDateTime zonedDateTime) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dateFormatter.format(zonedDateTime);
    }

}
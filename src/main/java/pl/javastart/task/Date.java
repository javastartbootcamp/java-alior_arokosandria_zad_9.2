package pl.javastart.task;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Date {

    public static boolean dateFormat(String dateFormatter) {
        Pattern compiledPattern = Pattern.compile("^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}");
        Matcher matcher = compiledPattern.matcher(dateFormatter);
        return matcher.matches();
    }

    public static boolean dateFormatSecond(String dateFormatter) {
        Pattern compiledPattern = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}");
        Matcher matcher = compiledPattern.matcher(dateFormatter);
        return matcher.matches();
    }

    public static boolean dateFormatThird(String dateFormatter) {
        Pattern compiledPattern = Pattern.compile("^\\d{2}\\.\\d{2}\\.\\d{4} \\d{2}:\\d{2}:\\d{2}");
        Matcher matcher = compiledPattern.matcher(dateFormatter);
        return matcher.matches();
    }

    public static ZonedDateTime returnDate(String date) {
        DateTimeFormatter dateFormatter;
        ZonedDateTime localDateTime;
        if (dateFormat(date)) {
            dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            localDateTime = LocalDateTime.parse(date, dateFormatter).atZone(ZoneId.systemDefault());
        } else if (dateFormatSecond(date)) {
            dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            localDateTime = LocalDateTime.parse(date + " 00:00", dateFormatter).atZone(ZoneId.systemDefault());
        } else if (dateFormatThird(date)) {
            dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
            localDateTime = LocalDateTime.parse(date, dateFormatter).atZone(ZoneId.systemDefault());

        } else {
            throw new DateTimeException(date);
        }
        return localDateTime;
    }

    public static String formatCorrectTime(ZonedDateTime zonedDateTime) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dateFormatter.format(zonedDateTime);
    }

}
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
        if (dateFormat(date)) {
            dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        } else if (dateFormatSecond(date)) {
            dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            date = date + " 00:00";
        } else if (dateFormatThird(date)) {
            dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        } else {
            throw new DateTimeException(date);
        }
        return LocalDateTime.parse(date, dateFormatter).atZone(ZoneId.systemDefault());
    }

    public static String formatCorrectTime(ZonedDateTime zonedDateTime) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dateFormatter.format(zonedDateTime);
    }

}
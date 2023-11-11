package pl.javastart.task;

import java.time.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.run(new Scanner(System.in));
    }

    public void run(Scanner scanner) {
        System.out.println("Podaj datę:");
        String date = scanner.nextLine();
        ZonedDateTime localDateTimeWithZone = Date.returnDate(date);
        System.out.println("Czas lokalny: " + Date.formatCorrectTime(localDateTimeWithZone));
        System.out.println("UTC: " + Date.formatCorrectTime(localDateTimeWithZone.withZoneSameInstant(ZoneId.of("UTC"))));
        System.out.println("Londyn: " + Date.formatCorrectTime(localDateTimeWithZone.withZoneSameInstant(ZoneId.of("Europe/London"))));
        System.out.println("Los Angeles: " + Date.formatCorrectTime(localDateTimeWithZone.withZoneSameInstant(ZoneId.of("America/Los_Angeles"))));
        System.out.println("Sydney: " + Date.formatCorrectTime(localDateTimeWithZone.withZoneSameInstant(ZoneId.of("Australia/Sydney"))));
    }
}



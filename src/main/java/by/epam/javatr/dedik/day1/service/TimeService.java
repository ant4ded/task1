package by.epam.javatr.dedik.day1.service;

import java.time.LocalTime;
import java.time.Month;

public class TimeService {
    private static final int LEAP_YEAR_INDEX = 4;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;

    public static final int MAX_YEAR = 3000;

    public LocalTime calculateTime(int secondsPerDay) {
        return LocalTime.of(secondsPerDay / SECONDS_PER_HOUR,
                (secondsPerDay % SECONDS_PER_HOUR) / SECONDS_PER_MINUTE,
                secondsPerDay % SECONDS_PER_HOUR % SECONDS_PER_MINUTE);
    }

    private boolean checkLeapYear(int year) {
        return (year % LEAP_YEAR_INDEX) == 0;
    }

    public int calculateDays(Month month, int year) {
        return month.length(checkLeapYear(year));
    }
}

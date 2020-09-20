package epam.javatr.dedik.day1.service;

import by.epam.javatr.dedik.day1.service.TimeService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalTime;
import java.time.Month;
import java.util.Random;

import static org.testng.Assert.assertEquals;

public class TimeServiceTest {
    TimeService service;

    @BeforeClass
    public void initialize() {
        service = new TimeService();
    }

    @DataProvider
    public Object[][] getDataLeapYear() {
        return new Object[][]{
                {Month.JANUARY, 31}, {Month.FEBRUARY, 29}, {Month.MARCH, 31},
                {Month.APRIL, 30}, {Month.MAY, 31}, {Month.JUNE, 30},
                {Month.JULY, 31}, {Month.AUGUST, 31}, {Month.SEPTEMBER, 30},
                {Month.OCTOBER, 31}, {Month.NOVEMBER, 30}, {Month.DECEMBER, 31}
        };
    }

    @DataProvider
    public Object[][] getDataYear() {
        return new Object[][]{
                {Month.JANUARY, 31}, {Month.FEBRUARY, 28}, {Month.MARCH, 31},
                {Month.APRIL, 30}, {Month.MAY, 31}, {Month.JUNE, 30},
                {Month.JULY, 31}, {Month.AUGUST, 31}, {Month.SEPTEMBER, 30},
                {Month.OCTOBER, 31}, {Month.NOVEMBER, 30}, {Month.DECEMBER, 31}
        };
    }

    @Test(dataProvider = "getDataLeapYear")
    public void calculateDays_daysLeapYear_days(Month month, int expected) {
        int leapYear = new Random(TimeService.MAX_YEAR / 4).nextInt() * 4;
        int actual = service.calculateDays(month, leapYear);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "getDataYear")
    public void calculateDays_daysYear_days(Month month, int expected) {
        int leapYear = new Random(TimeService.MAX_YEAR).nextInt();
        int actual = service.calculateDays(month, leapYear);
        assertEquals(actual, expected);
    }

    @Test
    public void calculateDays_monthLeapYear_days() {
        Month actualMonth = Month.FEBRUARY;
        int year = 0;
        int actual = service.calculateDays(actualMonth, year);
        int expected = 29;
        assertEquals(actual, expected);
    }

    @Test
    public void calculateDays_monthYear_days() {
        Month actualMonth = Month.FEBRUARY;
        int year = 13;
        int actual = service.calculateDays(actualMonth, year);
        int expected = 28;
        assertEquals(actual, expected);
    }

    @Test
    public void calculateTime_seconds_localTime() {
        LocalTime actual = service.calculateTime(4605);
        LocalTime expected = LocalTime.of(1, 16, 45);
        assertEquals(actual, expected);
    }
}

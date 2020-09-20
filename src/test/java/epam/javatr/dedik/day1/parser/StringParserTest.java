package epam.javatr.dedik.day1.parser;

import by.epam.javatr.dedik.day1.parser.StringParser;
import by.epam.javatr.dedik.day1.exception.ParseException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Month;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class StringParserTest {
    private StringParser parser;

    @BeforeClass
    private void initialize() {
        parser = new StringParser();
    }

    @Test
    public void toInteger_stringWithIntegerNumber_intNumber() {
        String actual = "450";
        int expected = 450;
        try {
            assertEquals(parser.toInteger(actual), expected);
        } catch (ParseException e) {
            fail(e.getMessage());
        }
    }

    @Test(expectedExceptions = ParseException.class,
            expectedExceptionsMessageRegExp = "Received value is not integer number.")
    public void toInteger_notNumber_convertedException() throws ParseException {
        parser.toInteger("qwe");
    }

    @Test
    public void toDouble_stringWithDoubleNumber_doubleNumber() {
        String actual = "13.456";
        double expected = 13.456;
        try {
            assertEquals(parser.toDouble(actual), expected);
        } catch (ParseException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void toDouble_stringWithIntegerNumber_doubleNumber() {
        String actual = "13456";
        double expected = 13456;
        try {
            assertEquals(parser.toDouble(actual), expected);
        } catch (ParseException e) {
            fail(e.getMessage());
        }
    }

    @Test(expectedExceptions = ParseException.class,
            expectedExceptionsMessageRegExp = "Received value is not double number.")
    public void toDouble_notNumber_convertException() throws ParseException {
        parser.toDouble("qwe");
    }


    @Test
    public void toMonth_stringWithMonthNumber_month() {
        String actual = "12";
        Month expected = Month.DECEMBER;
        try {
            assertEquals(parser.toMonth(actual), expected);
        } catch (ParseException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void toMonth_stringWithMonthName_month() {
        String actual = "December";
        Month expected = Month.DECEMBER;
        try {
            assertEquals(parser.toMonth(actual), expected);
        } catch (ParseException e) {
            fail(e.getMessage());
        }
    }

    @Test(expectedExceptions = ParseException.class,
            expectedExceptionsMessageRegExp = "Received value is not a month.")
    public void toMonth_stringWithoutMonthName_month() throws ParseException {
        String actual = "Dqwe";
        parser.toMonth(actual);
    }

    @Test(expectedExceptions = ParseException.class,
            expectedExceptionsMessageRegExp = "Received value is not a month.")
    public void toMonth_stringWithNotMonthNumber_month() throws ParseException {
        String actual = "122";
        parser.toMonth(actual);
    }

    @Test(expectedExceptions = ParseException.class,
            expectedExceptionsMessageRegExp = "Received value is not a month.")
    public void toMonth_stringWithShortMonthName_month() throws ParseException {
        String actual = "Dec";
        parser.toMonth(actual);
    }

    @Test
    public void toYear_correctYear_year() {
        String actual = "200";
        int expected = 200;
        try {
            assertEquals(parser.toYear(actual), expected);
        } catch (ParseException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void toYear_negativeYear_year() {
        String actual = "-200";
        int expected = -200;
        try {
            assertEquals(parser.toYear(actual), expected);
        } catch (ParseException e) {
            fail(e.getMessage());
        }
    }
}

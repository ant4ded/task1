package epam.javatr.dedik.day1.validation;

import by.epam.javatr.dedik.day1.validation.TimeValidator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class TimeValidationTest {
    private TimeValidator validator;

    @BeforeClass
    private void initialize() {
        validator = new TimeValidator();
    }

    @Test
    public void isValidMonth_numberMonth_true() {
        assertTrue(validator.isValidMonth("12"));
    }

    @Test
    public void isValidMonth_notMonthNumber_false() {
        assertFalse(validator.isValidMonth("112"));
    }

    @Test
    public void isValidMonth_numberMonthWithSymbol_false() {
        assertFalse(validator.isValidMonth("12q"));
    }

    @Test
    public void isValidMonth_uppercaseStringMonth_true() {
        assertTrue(validator.isValidMonth("FEBRUARY"));
    }

    @Test
    public void isValidMonth_lowercaseStringMonth_true() {
        assertTrue(validator.isValidMonth("february"));
    }

    @Test
    public void isValidMonth_shortStringMonth_false() {
        assertFalse(validator.isValidMonth("Feb"));
    }

    @Test
    public void isValidMonth_notStringMonth_false() {
        assertFalse(validator.isValidMonth("Fff"));
    }

    @Test
    public void isValidYear_correctYear_true() {
        assertTrue(validator.isValidYear("2000"));
    }

    @Test
    public void isValidYear_negativeYear_true() {
        assertTrue(validator.isValidYear("-100"));
    }

    @Test
    public void isValidYear_notNumber_false() {
        assertFalse(validator.isValidYear("-100q"));
    }

    @Test
    public void isValidYear_lowerLimitNumber_false() {
        assertFalse(validator.isValidYear("-1000"));
    }

    @Test
    public void isValidYear_upperLimitNumber_false() {
        assertFalse(validator.isValidYear("3000"));
    }
}

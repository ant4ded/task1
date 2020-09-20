package epam.javatr.dedik.day1.validation;

import by.epam.javatr.dedik.day1.validation.NumberValidator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class NumberValidationTest {
    private NumberValidator validator;

    @BeforeClass
    private void initialize() {
        validator = new NumberValidator();
    }

    @Test
    public void isInteger_integer_true() {
        assertTrue(validator.isInteger("-1000"));
    }

    @Test
    public void isInteger_bigNumber_false() {
        assertFalse(validator.isInteger("10000000000"));
    }

    @Test
    public void isInteger_notNumber_false() {
        assertFalse(validator.isInteger("1000q"));
    }

    @Test
    public void isDouble_double_true() {
        assertTrue(validator.isDouble("123.456"));
    }

    @Test
    public void isDouble_integer_true() {
        assertTrue(validator.isDouble("123"));
    }

    @Test
    public void isDouble_bigNumberAfterPoint_true() {
        assertTrue(validator.isDouble("123.987984651321321546848768451468798415164686451"));
    }

    @Test
    public void isDouble_notNumber_false() {
        assertFalse(validator.isDouble("123..987984651321321546848768451468798415164686451"));
    }

    @Test
    public void isDouble_bigNumberAfterPointWithSymbol_false() {
        assertFalse(validator.isDouble("123.9879846513213215468487684514687984151646864511q"));
    }
}

package epam.javatr.dedik.day1.service;

import by.epam.javatr.dedik.day1.service.ArithmeticService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArithmeticServiceTest {
    ArithmeticService service;

    @BeforeClass
    public void initialize() {
        service = new ArithmeticService();
    }

    @Test
    public void calculateLastNumberSquare_number_lastNumberSquare() {
        int actual = service.calculateLastNumberSquare(1449);
        int expected = 1;
        assertEquals(actual, expected);
    }

    @Test
    public void isEven_unsignedEvenNumber_true() {
        int number = 2;
        assertTrue(service.isEven(number));
    }

    @Test
    public void isEven_negativeEvenNumber_true() {
        int number = -2;
        assertTrue(service.isEven(number));
    }

    @Test
    public void isEven_zero_false() {
        int number = 0;
        assertFalse(service.isEven(number));
    }

    @Test
    public void isLimitEven_evenArray_true() {
        int[] array = {4, 5, 5, 2, 3};
        assertTrue(service.isLimitEven(array));
    }

    @Test
    public void isLimitEven_numberArray_false() {
        int[] array = {1, 1, 1, 1, 1, 1};
        assertFalse(service.isLimitEven(array));
    }

    @Test
    public void isNumberPerfect_perfectNumber_true() {
        int number = 28;
        assertTrue(service.isNumberPerfect(number));
    }

    @Test
    public void isNumberPerfect_number_false() {
        int number = 29;
        assertFalse(service.isNumberPerfect(number));
    }

    @Test
    public void calculateFunction_three_number() {
        double actual = service.calculateFunction(3);
        double expected = 9;
        assertEquals(actual, expected);
    }

    @Test
    public void calculateFunction_lessThree_number() {
        double actual = service.calculateFunction(0);
        double expected = -0.16666666666666666;
        assertEquals(actual, expected);
    }
}

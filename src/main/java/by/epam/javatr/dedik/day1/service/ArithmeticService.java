package by.epam.javatr.dedik.day1.service;

import java.util.Random;

import static java.lang.Math.pow;

public class ArithmeticService {
    public static final int LIMIT = 2;

    public int calculateLastNumberSquare(int number) {
        String stringNumber = String.valueOf(number);
        int lastNumeric = Integer.parseInt(String.valueOf(stringNumber.charAt(stringNumber.length() - 1)));

        String squareLastNumeric = String.valueOf((int) pow(lastNumeric, 2));
        return Integer.parseInt(String.valueOf(squareLastNumeric.charAt(squareLastNumeric.length() - 1)));
    }

    public boolean isEven(int number) {
        return number != 0 && number % 2 == 0;
    }

    public boolean isLimitEven(int[] numbers) {
        int count = 0;
        boolean result = false;
        for (int number : numbers) {
            if (number != 0 && isEven(number)) {
                count++;
            }
            if (count >= LIMIT) {
                result = true;
            }
        }
        return result;
    }

    public boolean isNumberPerfect(int number) {
        int dividerAmount = 0;
        for (int i = 1; i < number; ++i) {
            if (number % i == 0) {
                dividerAmount += i;
            }
        }
        return dividerAmount == number;
    }

    public double calculateFunction(int x) {
        double result;
        if (x >= 3) {
            result = -(x * x) + 3 * x + 9;
        } else {
            result = 1 / (pow(x, 3) - 6);
        }
        return result;
    }
}

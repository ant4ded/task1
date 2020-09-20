package by.epam.javatr.dedik.day1.validation;

import java.time.Month;

public class TimeValidator {
    private static final int BEGIN_VALID_INTERVAL = -1000;
    private static final int END_VALID_INTERVAL = 3000;

    private NumberValidator validator = new NumberValidator();

    public boolean isValidMonth(String month) {
        boolean result = false;
        if (validator.isInteger(month)) {
            int numberMonth = Integer.parseInt(month);
            if (numberMonth > 1 && numberMonth <= 12) {
                result = true;
            }
        } else {
            int i = 0;
            while (i < Month.values().length) {
                if (month.compareToIgnoreCase(Month.values()[i].name()) == 0) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    public boolean isValidYear(String year) {
        boolean result = false;
        if (validator.isInteger(year)) {
            int numberYear = Integer.parseInt(year);
            if (numberYear > BEGIN_VALID_INTERVAL && numberYear < END_VALID_INTERVAL) {
                result = true;
            }
        }
        return result;
    }
}

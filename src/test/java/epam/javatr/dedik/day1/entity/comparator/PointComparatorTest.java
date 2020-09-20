package epam.javatr.dedik.day1.entity.comparator;

import by.epam.javatr.dedik.day1.entity.Point;
import by.epam.javatr.dedik.day1.entity.comparator.PointComparator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PointComparatorTest {
    PointComparator comparator;

    @BeforeClass
    private void initialize() {
        comparator = new PointComparator();
    }

    @Test
    public void compare_twoPoints_firstPoint() {
        Point a = new Point(45, 15);
        Point b = new Point(75, 13);
        int actual = comparator.compare(a, b);
        int expected = -1;
        assertEquals(actual, expected);
    }

    @Test
    public void compare_equalsPoints_firstPoint() {
        Point a = new Point(45, 15);
        Point b = new Point(45, 15);
        int actual = comparator.compare(a, b);
        int expected = 0;
        assertEquals(actual, expected);
    }

    @Test
    public void compare_twoPoints_secondPoint() {
        Point a = new Point(30, 15);
        Point b = new Point(5, 5);
        int actual = comparator.compare(a, b);
        int expected = 1;
        assertEquals(actual, expected);
    }
}

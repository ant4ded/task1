package epam.javatr.dedik.day1.service;

import by.epam.javatr.dedik.day1.entity.Point;
import by.epam.javatr.dedik.day1.service.GeometricService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertSame;

public class GeometricServiceTest {
    GeometricService service;

    @BeforeClass
    public void initialize() {
        service = new GeometricService();
    }

    @Test
    public void calculateNestedSquareArea_describedArea_nestedArea() {
        double describedArea = 50;
        double actual = service.calculateNestedSquareArea(describedArea);
        double expected = 25;
        assertEquals(actual, expected);
    }

    @Test
    public void calculateTranscendence_describedAndNestedArea_transcendence() {
        double describedArea = 50;
        double nestedArea = 25;
        double actual = service.calculateTranscendence(describedArea, nestedArea);
        double expected = 2;
        assertEquals(actual, expected);
    }

    @Test
    public void nearestPoint_twoPoints_nearestPoint() {
        Point a = new Point(45, 15);
        Point b = new Point(78, 65);
        Point actual = service.nearestPoint(a, b);
        Point expected = a;
        assertSame(actual, expected);
    }

    @Test
    public void nearestPoint_equalsPoints_nearestPoint() {
        Point a = new Point(45, 15);
        Point b = new Point(45, 15);
        Point actual = service.nearestPoint(a, b);
        Point expected = a;
        assertSame(actual, expected);
    }

    @Test
    public void calculateLengthCircle_radius_lengthCircle() {
        int radius = 5;
        double actual = service.calculateLengthCircle(radius);
        double expected = 31.41592653589793;
        assertEquals(actual, expected);
    }

    @Test
    public void calculateAreaCircle_radius_areaCircle() {
        int radius = 5;
        double actual = service.calculateAreaCircle(radius);
        double expected = 78.53981633974483;
        assertEquals(actual, expected);
    }

    @Test
    public void calculateTangentOnInterval() {
        int begin = 0;
        int end = 250;
        int step = 50;
        List<Double> actual = service.calculateTangentOnInterval(begin, end, step);
        double[] list = {0, 1.192, -5.671, -0.577, 0.364, 2.747};
        List<Double> expected = DoubleStream.of(list).boxed().collect(Collectors.toCollection(ArrayList::new));
        assertEquals(actual, expected);
    }
}

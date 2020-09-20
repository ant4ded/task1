package by.epam.javatr.dedik.day1.entity.comparator;

import by.epam.javatr.dedik.day1.entity.Point;

import java.util.Comparator;

import static java.lang.Math.hypot;

public class PointComparator implements Comparator<Point> {
    private double calculateInterval(Point point) {
        double interval;
        if (point.getX() == 0) {
            interval = point.getY();
        } else if (point.getY() == 0) {
            interval = point.getX();
        } else {
            interval = hypot(point.getX(), point.getY());
        }
        return interval;
    }

    @Override
    public int compare(Point first, Point second) {
        double intervalFirstPoint = calculateInterval(first);
        double intervalSecondPoint = calculateInterval(second);
        return Double.compare(intervalFirstPoint, intervalSecondPoint);
    }
}

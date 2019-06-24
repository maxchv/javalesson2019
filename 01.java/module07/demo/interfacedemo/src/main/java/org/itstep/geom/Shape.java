package org.itstep.geom;

import java.util.Arrays;

public class Shape {
    public static final int MAX_POINTS = 100_000;

    private Point[] points;

    public Shape(Point[] points) {
        this.points = points;
    }

    public Point[] getPoints() {
        return points;
    }

    public void setPoints(Point[] points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "points=" + Arrays.toString(points) +
                '}';
    }
}

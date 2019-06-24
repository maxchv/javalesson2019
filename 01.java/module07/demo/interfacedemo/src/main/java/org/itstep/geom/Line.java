package org.itstep.geom;

public class Line {
    private Point point1;
    private Point point2;

    public Line(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public Point getPoint1() {
        return point1;
    }

    public void setPoint1(Point point1) {
        this.point1 = point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
    }

    public void draw() {
        System.out.printf("Draw line from %s to %s length %g\n",
                point1.toString(), point2, distance());
    }

    private double distance() {
        return Math.sqrt(Math.pow(point1.getX() - point2.getX(), 2)+
                         Math.pow(point1.getY() - point2.getY(), 2));
    }
}

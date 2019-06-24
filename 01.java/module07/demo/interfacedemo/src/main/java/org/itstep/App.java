package org.itstep;

import org.itstep.geom.*;

public class App {
    public static void main(String[] args) {
        Point p1 = new Point(10, 100);
        Point p2 = new Point(100, 10);
        System.out.println(p1);
        Line line = new Line(p1, p2);
        line.draw();
        Rectangle rect = new Rectangle(new Point(0,0), 10, 5);
        rect.draw();
        rect.defaultMethod();
    }
}


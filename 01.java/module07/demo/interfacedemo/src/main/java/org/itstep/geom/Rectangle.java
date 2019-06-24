package org.itstep.geom;

public class Rectangle extends Shape implements Printable, Drawable {
    private final int width;
    private final int height;

    public Rectangle(Point leftUpper, int width, int height) {
        super(new Point[]{leftUpper, new Point(leftUpper.getX() + width, leftUpper.getY() + height)});
        this.width = width;
        this.height = height;
    }

    @Override
    public final void draw() {
        for(int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    @Override
    public void print() {

    }
}


class R extends Rectangle {

    public R(Point leftUpper, int width, int height) {
        super(leftUpper, width, height);
    }

    public void draw(int i) {

    }
}
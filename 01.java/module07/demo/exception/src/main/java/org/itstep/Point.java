package org.itstep;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public int getX() {
        return x;
    }

    public void setX(int xx) {
        x = xx;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

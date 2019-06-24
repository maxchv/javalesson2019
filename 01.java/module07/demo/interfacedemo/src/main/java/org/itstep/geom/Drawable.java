package org.itstep.geom;

public interface Drawable {
    int RESOLUTION = 300;
    void draw();

    default void defaultMethod() {
        System.out.println("Default method");
    }
}

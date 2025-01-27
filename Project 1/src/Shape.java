// Andrii Malakhovtsev
// Shapes, Phase 1

import java.awt.Graphics;
import java.awt.Point;

public abstract class Shape {
    private Point p1;
    private Point p2;
    private double color;

    public Shape(Point p1, Point p2, double color) {
        this.p1 = p1;
        this.p2 = p2;
        this.color = color;
    }

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public double getColor() {
        return color;
    }

    public void setColor(double color) {
        this.color = color;
    }

    public abstract void draw(Graphics g);
}

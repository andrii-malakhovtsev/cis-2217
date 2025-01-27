// Andrii Malakhovtsev
// Shapes, Phase 1

import java.awt.Graphics;
import java.awt.Point;

/**
 * Abstract class representing a Shape.
 * All shapes must define two points and a color.
 *
 * @author Andrii Malakhovtsev
 * @version 1.0
 */

public abstract class Shape {
    private Point p1;
    private Point p2;
    private double color;

    /**
     * Constructs a Shape object with two points and a color.
     *
     * @param p1 the first point.
     * @param p2 the second point.
     * @param color the color of the shape, represented as a double.
     */
    public Shape(Point p1, Point p2, double color) {
        this.p1 = p1;
        this.p2 = p2;
        this.color = color;
    }

    /**
     * Gets the first point of the shape.
     *
     * @return the first point of the shape.
     */
    public Point getP1() {
        return p1;
    }

    /**
     * Sets the first point of the shape.
     *
     * @param p1 the first point.
     */
    public void setP1(Point p1) {
        this.p1 = p1;
    }

    /**
     * Gets the second point of the shape.
     *
     * @return the second point of the shape.
     */
    public Point getP2() {
        return p2;
    }

    /**
     * Sets the second point of the shape.
     *
     * @param p2 the second point.
     */
    public void setP2(Point p2) {
        this.p2 = p2;
    }

    /**
     * Gets the color of the shape.
     *
     * @return the color of the shape as a double.
     */
    public double getColor() {
        return color;
    }

    /**
     * Sets the color of the shape.
     *
     * @param color the color of the shape as a double.
     */
    public void setColor(double color) {
        this.color = color;
    }

    /**
     * Abstract method for drawing the shape.
     * Subclasses must implement this method to define how the shape is drawn.
     *
     * @param g the Graphics object to draw the shape on.
     */
    public abstract void draw(Graphics g);
}

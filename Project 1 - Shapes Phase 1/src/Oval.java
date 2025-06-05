import java.awt.Graphics;
import java.awt.Point;

/**
 * Class representing an Oval.
 * The oval is drawn within a bounding rectangle determined by two points.
 *
 * @author Andrii Malakhovtsev
 * @version 1.0
 */

public class Oval extends Shape {

    /**
     * Constructs an Oval object with two points and a color.
     *
     * @param p1 the first point (top-left corner of the bounding rectangle).
     * @param p2 the second point (bottom-right corner of the bounding rectangle).
     * @param color the color of the oval.
     */
    public Oval(Point p1, Point p2, double color) {
        super(p1, p2, color);
    }

    /**
     * Draws the oval on the given Graphics object.
     * The oval is drawn using the top-left and bottom-right points.
     *
     * @param g the Graphics object used for drawing.
     */
    @Override
    public void draw(Graphics g) {
        // Oval drawing logic (left empty for now)
    }
}

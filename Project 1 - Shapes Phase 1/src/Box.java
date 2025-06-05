import java.awt.Graphics;
import java.awt.Point;

/**
 * Class representing a Box.
 * The box is drawn between two points.
 *
 * @author Andrii Malakhovtsev
 * @version 1.0
 */

public class Box extends Shape {

    /**
     * Constructs a Box object with two points and a color.
     *
     * @param p1 the first corner point (top-left corner of the box).
     * @param p2 the second corner point (bottom-right corner of the box).
     * @param color the color of the box.
     */
    public Box(Point p1, Point p2, double color) {
        super(p1, p2, color);
    }

    /**
     * Draws the box on the given Graphics object.
     * The box is drawn using the top-left and bottom-right points.
     *
     * @param g the Graphics object used for drawing.
     */
    @Override
    public void draw(Graphics g) {
        // Box drawing logic (left empty for now)
    }
}

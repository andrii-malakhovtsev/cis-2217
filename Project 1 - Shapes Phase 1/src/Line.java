import java.awt.Graphics;
import java.awt.Point;

/**
 * Class representing a Line.
 * The line is drawn between two points.
 *
 * @author Andrii Malakhovtsev
 * @version 1.0
 */

public class Line extends Shape {

    /**
     * Constructs a Line object with two points and a color.
     *
     * @param p1 the first point representing the start of the line.
     * @param p2 the second point representing the end of the line.
     * @param color the color of the line.
     */
    public Line(Point p1, Point p2, double color) {
        super(p1, p2, color);
    }

    /**
     * Draws the line on the given Graphics object.
     * The line is drawn between the two points p1 and p2.
     *
     * @param g the Graphics object used for drawing.
     */
    @Override
    public void draw(Graphics g) {
        // Line drawing logic (left empty for now)
    }
}

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.awt.Point;

/**
 * Unit test for the Line class.
 * This test verifies the constructor and getter methods of the Line class.
 *
 * @author Andrii Malakhovtsev
 * @version 1.0
 */

public class LineTest {

    /**
     * Tests the constructor of the Line class.
     * Verifies that the two points and color are correctly set in the Line object.
     *
     * @param p1 the first point that defines the start of the line.
     * @param p2 the second point that defines the end of the line.
     * @param color the color of the line.
     */

    @Test
    public void testLineConstructor() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(10, 10);
        Line line = new Line(p1, p2, 0.5);

        assertEquals(p1, line.getP1());
        assertEquals(p2, line.getP2());
        assertEquals(0.5, line.getColor(), 0.001);
    }
}

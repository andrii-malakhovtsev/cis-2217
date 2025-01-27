// Andrii Malakhovtsev
// Shapes, Phase 1

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.awt.Point;

public class LineTest {

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

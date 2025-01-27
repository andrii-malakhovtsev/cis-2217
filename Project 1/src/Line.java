// Andrii Malakhovtsev
// Shapes, Phase 1

import java.awt.Graphics;
import java.awt.Point;

public class Line extends Shape {

    public Line(Point p1, Point p2, double color) {
        super(p1, p2, color);
    }

    @Override
    public void draw(Graphics g) {
        // Line drawing logic (left empty for now)
    }
}

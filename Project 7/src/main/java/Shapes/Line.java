// Andrii Malakhovtsev
// Shapes, Phase 3

package Shapes;

import java.awt.*;

public class Line extends Shape {
    public Line(int x1, int y1, int x2, int y2, Color color) {
        super(x1, y1, x2, y2, color);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.drawLine(x1, y1, x2, y2);
    }
}
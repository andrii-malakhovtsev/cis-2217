// Andrii Malakhovtsev
// House

package Project2.House;

import java.awt.*;

import Project2.IsosTriangle;

public class Roof {
    public static void paint(Graphics g, int x, int y) {
        g.setColor(Color.DARK_GRAY);
        IsosTriangle.paint(g, x - 30, y - 20, 260, 90, g.getColor());
    }
}

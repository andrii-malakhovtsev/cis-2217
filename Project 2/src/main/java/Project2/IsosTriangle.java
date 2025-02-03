// Andrii Malakhovtsev
// House

package Project2;

import java.awt.*;

public class IsosTriangle {
    public static void paint(Graphics g, int x, int y, int base, int height, Color color) {
        int[] xPoints = {x, x + base / 2, x + base};
        int[] yPoints = {y + height, y, y + height};
        g.setColor(color);
        g.fillPolygon(xPoints, yPoints, 3);
    }
}

package Project2.Scenery;

import Project2.IsosTriangle;

import java.awt.*;

public class Tree {
    public static void paint(Graphics g, int x, int y) {
        g.setColor(new Color(139, 69, 19)); // Brown trunk
        g.fillRect(x + 30, y + 50, 20, 50); // Trunk

        g.setColor(new Color(9, 93, 19)); // Dark Green
        Color leafColor = g.getColor();

        IsosTriangle.paint(g, x + 10, y - 10, 60, 30, leafColor);
        IsosTriangle.paint(g, x, y + 10, 80, 30, leafColor);
        IsosTriangle.paint(g, x - 10, y + 30, 100, 30, leafColor);
        IsosTriangle.paint(g, x - 15, y + 50, 120, 30, leafColor);
    }
}

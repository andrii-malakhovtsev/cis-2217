package Project2.House;

import java.awt.*;

public class House {
    public static void paint(Graphics g, int x, int y) {
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, 200, 150); // House Base

        Chimney.paint(g, x + 160, y - 50);
        Roof.paint(g, x, y - 50);
        Window.paint(g, x + 30, y + 30, 30, 40, false);
        Window.paint(g, x + 140, y + 30, 30, 40, false);
        Window.paint(g, x + 30, y + 90, 40, 30, false);
        Window.paint(g, x + 130, y + 90, 40, 30, false);
        Window.paint(g, x + 85, y + 30, 30, 30, true);
        Door.paint(g, x + 80, y + 80);
    }
}

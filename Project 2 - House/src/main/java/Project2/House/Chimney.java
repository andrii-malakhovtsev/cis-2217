package Project2.House;

import java.awt.*;

public class Chimney {
    public static void paint(Graphics g, int x, int y) {
        g.setColor(Color.GRAY);
        g.fillRect(x, y, 30, 60); // Chimney base

        // Clouds
        g.setColor(Color.WHITE);
        g.fillOval(x + 10, y - 20, 20, 15);
        g.fillOval(x + 40, y - 30, 20, 15);
        g.fillOval(x + 70, y - 40, 20, 15);
    }
}

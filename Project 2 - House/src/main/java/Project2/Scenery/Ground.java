package Project2.Scenery;

import java.awt.*;

public class Ground {
    public static void paint(Graphics g) {
        g.setColor(new Color(34, 140, 34)); // Grass Green
        g.fillRect(0, 400, 800, 300); // Fills the bottom half of the screen for grass
    }
}

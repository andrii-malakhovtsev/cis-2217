// Andrii Malakhovtsev
// House

package Project2.House;

import java.awt.*;

public class Door {
    public static void paint(Graphics g, int x, int y) {
        g.setColor(new Color(139, 69, 19)); // Brown Oak
        g.fillRect(x, y - 10, 40, 80); // Door

        g.setColor(Color.BLACK);
        g.fillOval(x + 30, y + 40, 5, 5); // Door Handle
    }
}

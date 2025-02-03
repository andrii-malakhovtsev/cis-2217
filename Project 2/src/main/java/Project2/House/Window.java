// Andrii Malakhovtsev
// House

package Project2.House;

import java.awt.*;

public class Window {
    public static void paint(Graphics g, int x, int y, int width, int height, boolean round) {
        g.setColor(Color.CYAN);

        if (round) {
            g.fillOval(x, y, width, height);
        }
        else {
            g.fillRect(x, y, width, height);
        }

        // Drawing Outline
        g.setColor(Color.BLACK);

        if (round) {
            g.drawOval(x, y, width, height);
        }
        else {
            g.drawRect(x, y, width, height);
        }

        // Drawing Cross Outline on Windows
        g.drawLine(x, y + height / 2, x + width, y + height / 2);
        g.drawLine(x + width / 2, y, x + width / 2, y + height);
    }
}

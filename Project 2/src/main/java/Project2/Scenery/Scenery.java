// Andrii Malakhovtsev
// House

package Project2.Scenery;

import java.awt.*;

public class Scenery {
    public static void paint(Graphics g) {
        // Paint background
        Sky.paint(g);
        Ground.paint(g);

        // Paint trees
        Tree.paint(g, 100, 300);
        Tree.paint(g, 500, 300);
    }
}

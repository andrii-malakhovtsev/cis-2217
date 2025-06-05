package Project2;

import Project2.House.House;
import Project2.Scenery.Scenery;

import javax.swing.*;
import java.awt.*;

/**
 * Class representing a Picture.
 * Calls all other classes for their "paint" methods.
 *
 * @author Andrii Malakhovtsev
 * @version 1.0
 */

public class Picture extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Paint Scenery
        Scenery.paint(g);

        // Paint house
        House.paint(g, 250, 250);

        // Name
        g.setColor(Color.BLACK);
        g.drawString("Student: Andrii Malakhovtsev", 10, 20);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("House Picture");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.add(new Picture());
            frame.setVisible(true);
        });
    }
}

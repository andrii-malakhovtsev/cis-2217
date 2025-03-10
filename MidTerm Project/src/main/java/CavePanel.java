// Andrii Malakhovtsev
// MidTerm Project - Cave Diver

import javax.swing.*;
import java.awt.*;

/**
 * A custom JPanel used to render and display the cave grid.
 * Responsible for drawing the cave and its escape route.
 */
public class CavePanel extends JPanel {
    private final Cave cave;

    /**
     * Constructor that initializes the cave and sets the preferred size for the panel.
     *
     * @param cave The Cave object to display.
     */
    public CavePanel(Cave cave) {
        this.cave = cave;
        setPreferredSize(new Dimension(500, 500)); // Size of the panel to render the cave grid
    }

    /**
     * Paints the cave grid and escape route on the panel.
     * This method is called whenever the panel needs to be re-drawn.
     *
     * @param g graphics object used to draw the cave grid.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Get the cave grid
        CaveCell[][] caveGrid = cave.getCaveGrid();
        int cellSize = 50; // Size of each cell

        // Calculate the grid's starting offset to center it in the panel
        int offsetX = (getWidth() - caveGrid[0].length * cellSize) / 2;
        int offsetY = (getHeight() - caveGrid.length * cellSize) / 2;

        // Iterate through each cell and draw it
        for (int i = 0; i < caveGrid.length; i++) {
            for (int j = 0; j < caveGrid[i].length; j++) {
                // Set the color based on the depth of the cell
                g.setColor(caveGrid[i][j].getColor());

                // Draw the cell
                g.fillRect(offsetX + j * cellSize, offsetY + i * cellSize, cellSize, cellSize);

                // Draw the escape route on top of the cell if it's part of the escape route
                if (caveGrid[i][j].isPartOfEscapeRoute()) {
                    g.setColor(Color.RED); // Escape route cells are highlighted in red
                    g.fillRect(offsetX + j * cellSize, offsetY + i * cellSize, cellSize, cellSize);
                }

                // Draw the cell borders
                g.setColor(Color.BLACK);
                g.drawRect(offsetX + j * cellSize, offsetY + i * cellSize, cellSize, cellSize);

                // Draw the depth of each cell, centered inside the cell
                String depthText = String.valueOf(caveGrid[i][j].getDepth()); // Get the depth of the cell
                g.setColor(Color.WHITE); // White text color
                FontMetrics metrics = g.getFontMetrics();
                int textX = offsetX + j * cellSize + (cellSize - metrics.stringWidth(depthText)) / 2;
                int textY = offsetY + i * cellSize + (cellSize + metrics.getHeight()) / 2 - 3;
                g.drawString(depthText, textX, textY);
            }
        }
    }
}

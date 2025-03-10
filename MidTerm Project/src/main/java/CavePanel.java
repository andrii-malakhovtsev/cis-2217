import javax.swing.*;
import java.awt.*;

/**
 * The JPanel that displays the cave grid.
 */
public class CavePanel extends JPanel {
    private final int CELL_LENGTH = 50;
    private Cave cave; // The cave to be displayed
    private Color escapePathColor = new Color(242, 0, 0);

    public CavePanel(Cave cave) {
        this.cave = cave;
    }

    /**
     * Paints the cave grid onto the panel.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Get the width and height of the panel
        int panelWidth = getWidth();
        int panelHeight = getHeight();

        // Get the dimensions of the cave grid
        int caveWidth = cave.getCaveGrid()[0].length * CELL_LENGTH;
        int caveHeight = cave.getCaveGrid().length * CELL_LENGTH;

        // Calculate the offsets to center the grid
        int xOffset = (panelWidth - caveWidth) / 2;
        int yOffset = (panelHeight - caveHeight) / 2;

        // Loop through the cave grid to draw the cells
        for (int i = 0; i < cave.getCaveGrid().length; i++) {
            for (int j = 0; j < cave.getCaveGrid()[i].length; j++) {
                CaveCell cell = cave.getCaveGrid()[i][j];
                g.setColor(cell.getColor());  // Use the color of each cell
                g.fillRect(j * CELL_LENGTH + xOffset, i * CELL_LENGTH + yOffset, CELL_LENGTH, CELL_LENGTH);  // Draw the cell

                // Draw the escape route in red if part of the path
                if (cell.isPartOfEscapeRoute()) {
                    g.setColor(escapePathColor);  // Red color for escape path
                    g.fillRect(j * CELL_LENGTH + xOffset, i * CELL_LENGTH + yOffset, CELL_LENGTH, CELL_LENGTH);
                }

                // Draw the depth number on top of the cell
                g.setColor(Color.WHITE);
                String depthText = Integer.toString(cell.getDepth());
                g.drawString(depthText, j * CELL_LENGTH + xOffset + 15, i * CELL_LENGTH + yOffset + 25); // Adjust position for text
            }
        }
    }
}

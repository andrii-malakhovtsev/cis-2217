import java.awt.Color;

/**
 * Represents a single cell in the cave grid.
 */
public class CaveCell {
    private int row, col, depth;
    private boolean isPartOfEscapeRoute;
    private Color color;

    /**
     * Constructor to initialize a cave cell with its position and depth.
     */
    public CaveCell(int row, int col, int depth) {
        this.row = row;
        this.col = col;
        this.depth = depth;
        this.isPartOfEscapeRoute = false;
        this.color = getColorForDepth(depth); // Set color based on depth
    }

    /**
     * Set the color of the cave cell.
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Get the current color of the cave cell.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Set whether this cell is part of the escape route.
     */
    public void setPartOfEscapeRoute(boolean isPartOfEscapeRoute) {
        this.isPartOfEscapeRoute = isPartOfEscapeRoute;
    }

    /**
     * Check if this cell is part of the escape route.
     */
    public boolean isPartOfEscapeRoute() {
        return isPartOfEscapeRoute;
    }

    /**
     * Get the depth of the cave cell.
     */
    public int getDepth() {
        return depth;
    }

    /**
     * Helper method to get color based on depth.
     * Depth 1 is light blue and depth 10 is dark blue.
     */
    private Color getColorForDepth(int depth) {
        int blueValue = (int) (255 - (depth - 1) * 25.5); // Darker blue for deeper cells
        return new Color(0, 0, blueValue);  // RGB value with blue varying based on depth
    }
}

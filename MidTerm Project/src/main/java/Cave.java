import java.awt.Color;

public class Cave {
    private final int CELL_AMOUNT = 10;
    private CaveCell[][] caveGrid; // 2D array of CaveCell objects

    // Constructor
    public Cave() {
        caveGrid = new CaveCell[CELL_AMOUNT][CELL_AMOUNT];
        generateNewCave();
    }

    // Generate a new random cave
    public void generateNewCave() {
        for (int i = 0; i < caveGrid.length; i++) {
            for (int j = 0; j < caveGrid[i].length; j++) {
                int depth = (int) (Math.random() * CELL_AMOUNT) + 1;
                caveGrid[i][j] = new CaveCell(i, j, depth);
            }
        }
        resetEscapeRoute(); // Reset escape route when a new cave is generated
    }

    // Reset the escape route (marking cells that were part of an escape route as false)
    public void resetEscapeRoute() {
        for (int i = 0; i < caveGrid.length; i++) {
            for (int j = 0; j < caveGrid[i].length; j++) {
                caveGrid[i][j].setPartOfEscapeRoute(false); // reset the escape route flag
            }
        }
    }

    // Reset the colors of the cave grid based on the depth of each cell
    // This is done before starting a new escape attempt to reset any previously colored cells
    public void resetCaveColors() {
        for (int i = 0; i < caveGrid.length; i++) {
            for (int j = 0; j < caveGrid[i].length; j++) {
                // Reset each cell's color based on its depth
                caveGrid[i][j].setColor(getColorForDepth(caveGrid[i][j].getDepth()));
            }
        }
    }

    // Get the color for a cell based on its depth (depth 1 is light blue, depth 10 is dark blue)
    private Color getColorForDepth(int depth) {
        int blueValue = (int) (255 - (depth - 1) * 25.5); // Darker blue for deeper cells
        return new Color(0, 0, blueValue);  // RGB value with blue varying based on depth
    }

    // Getter for the cave grid
    public CaveCell[][] getCaveGrid() {
        return caveGrid;
    }

    // Escape logic for finding a path through the cave
    public boolean escape(int depthRating, int airUnits) {
        return findEscapeRoute(0, 0, depthRating, airUnits);
    }

    // Recursive method to try and find an escape route
    private boolean findEscapeRoute(int row, int col, int depthRating, int airUnits) {
        // Base cases
        if (row < 0 || row >= caveGrid.length || col < 0 || col >= caveGrid[row].length) {
            return false; // Out of bounds
        }
        if (airUnits <= 0 || caveGrid[row][col].getDepth() > depthRating) {
            return false; // No air left or depth too deep
        }
        if (row == caveGrid.length - 1 && col == caveGrid[row].length - 1) {
            caveGrid[row][col].setPartOfEscapeRoute(true); // Escape found
            return true;
        }

        // Mark the current cell as part of the escape route
        caveGrid[row][col].setPartOfEscapeRoute(true);

        // Try moving right or down
        boolean foundEscape = findEscapeRoute(row + 1, col, depthRating, airUnits - 1) ||
                findEscapeRoute(row, col + 1, depthRating, airUnits - 1);

        // If no escape found, unmark the cell and return false
        if (!foundEscape) {
            caveGrid[row][col].setPartOfEscapeRoute(false);
        }

        return foundEscape;
    }
}

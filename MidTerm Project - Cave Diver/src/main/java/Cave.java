import java.awt.Color;

/**
 * Represents the cave grid and the logic for the "Cave Diver" game.
 * Manages the cave grid, escape route, and the game's logic to determine if the player can escape.
 */
public class Cave {
    private final int CELL_AMOUNT_PER_LINE = 10;
    private CaveCell[][] caveGrid; // 2D array of CaveCell objects

    /**
     * Constructor that initializes the cave grid and generates the first cave.
     */
    public Cave() {
        caveGrid = new CaveCell[CELL_AMOUNT_PER_LINE][CELL_AMOUNT_PER_LINE];
        generateNewCave();
    }

    /**
     * Generates a new random cave, initializing each cell with a random depth.
     * Resets the escape route.
     */
    public void generateNewCave() {
        for (int i = 0; i < caveGrid.length; i++) {
            for (int j = 0; j < caveGrid[i].length; j++) {
                int depth = (int) (Math.random() * CELL_AMOUNT_PER_LINE) + 1;
                caveGrid[i][j] = new CaveCell(i, j, depth);
            }
        }
        resetEscapeRoute(); // Reset escape route when a new cave is generated
    }

    /**
     * Resets the escape route by marking all cells as not part of the escape route.
     */
    public void resetEscapeRoute() {
        for (int i = 0; i < caveGrid.length; i++) {
            for (int j = 0; j < caveGrid[i].length; j++) {
                caveGrid[i][j].setPartOfEscapeRoute(false); // reset the escape route flag
            }
        }
    }

    /**
     * Resets the colors of the cave grid based on the depth of each cell.
     * Done before starting a new escape attempt to reset any previously colored cells.
     */
    public void resetCaveColors() {
        for (int i = 0; i < caveGrid.length; i++) {
            for (int j = 0; j < caveGrid[i].length; j++) {
                // Reset each cell's color based on its depth
                caveGrid[i][j].setColor(getColorForDepth(caveGrid[i][j].getDepth()));
            }
        }
    }

    /**
     * Returns the color associated with the given depth.
     *
     * @param depth depth of the cell.
     * @return The color associated with the depth.
     */
    private Color getColorForDepth(int depth) {
        int blueValue = (int) (255 - (depth - 1) * 25.5); // Darker blue for deeper cells
        return new Color(0, 0, blueValue);  // RGB value with blue varying based on depth
    }

    /**
     * Getter for the cave grid.
     *
     * @return The 2D array representing the cave grid.
     */
    public CaveCell[][] getCaveGrid() {
        return caveGrid;
    }

    /**
     * Attempts to find an escape route in the cave using the given depth rating and air units.
     * The method calls the recursive method 'findEscapeRoute' to search for a valid escape route.
     *
     * @param depthRating rating of the depth the diver can safely navigate.
     * @param airUnits number of air units available to the diver.
     * @return True if an escape route is found, otherwise false.
     */
    public boolean escape(int depthRating, int airUnits) {
        return findEscapeRoute(0, 0, depthRating, airUnits);
    }

    /**
     * Recursive method that attempts to find a valid escape route from the cave.
     * It checks neighboring cells and moves right or down with considerations of depth.
     *
     * @param row current row of the cell being checked.
     * @param col current column of the cell being checked.
     * @param depthRating rating of the depth the diver can safely navigate.
     * @param airUnits remaining air units for the diver.
     * @return True if an escape route is found, otherwise false.
     */
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

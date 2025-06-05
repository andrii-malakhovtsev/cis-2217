import javax.swing.*;
import java.awt.*;

/**
 * The main class that runs the "Cave Diver" game.
 * It initializes the GUI, handles user input, and controls the flow of the game.
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create the main frame
            JFrame frame = new JFrame("Cave Diver - Find an Escape Route");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Create the cave and its panel
            Cave cave = new Cave();
            CavePanel cavePanel = new CavePanel(cave);

            // Set up the layout and controls
            frame.setLayout(new BorderLayout());

            // Center the main text at the top
            String mainText = "The diver begins in the upper-left corner and escapes by reaching the lower-right corner.";
            JLabel topTextLabel = new JLabel(mainText, JLabel.CENTER); // Center alignment
            frame.add(topTextLabel, BorderLayout.NORTH);

            // Create a panel to center the cave panel
            JPanel centerPanel = new JPanel();
            centerPanel.setLayout(new BorderLayout());
            centerPanel.add(cavePanel, BorderLayout.CENTER);
            frame.add(centerPanel, BorderLayout.CENTER);

            // Create controls for depth input and buttons
            JPanel controlPanel = new JPanel();
            controlPanel.setLayout(new FlowLayout());

            JTextField depthField = new JTextField(5);
            controlPanel.add(new JLabel("Enter Depth Rating:"));
            controlPanel.add(depthField);

            JButton escapeButton = new JButton("Escape");
            JButton newCaveButton = new JButton("New Cave");

            // Escape button action
            escapeButton.addActionListener(e -> {
                int depthRating = Integer.parseInt(depthField.getText());

                if (depthRating < 1 || depthRating > 10) {
                    JOptionPane.showMessageDialog(frame, "The depth number needs to be between 1-10",
                            "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                cave.resetCaveColors();  // Reset the colors before searching for a new escape
                cave.resetEscapeRoute(); // Reset escape route before trying a new path

                boolean foundEscape = cave.escape(depthRating, 20); // Try to find an escape route

                if (!foundEscape) {
                    JOptionPane.showMessageDialog(frame, "No escape route found!",
                            "Escape Failure", JOptionPane.ERROR_MESSAGE);
                }

                // Repaint the cave grid to show the updated path
                cavePanel.repaint();
            });

            // New cave button action
            newCaveButton.addActionListener(e -> {
                cave.generateNewCave();
                cavePanel.repaint();
            });

            // Add buttons to control panel
            controlPanel.add(escapeButton);
            controlPanel.add(newCaveButton);

            // Add control panel to frame
            frame.add(controlPanel, BorderLayout.SOUTH);

            // Set the frame size and visibility
            frame.setSize(600, 700);
            frame.setVisible(true);
        });
    }
}

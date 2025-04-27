// Andrii Malakhovtsev
// Shapes, Phase 3

import Shapes.Line;
import Shapes.Oval;
import Shapes.ShapeType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.LinkedList;

import java.io.*;

class DrawingCanvas extends JComponent {
    private LinkedList<Shapes.Shape> shapes = new LinkedList<>();
    private ShapeType currentShape = ShapeType.BOX; // Default to Shapes.Box
    private Color currentColor = Color.BLACK;
    private int startX, startY;
    private boolean drawing = false,
                    trails = false;

    public DrawingCanvas() {
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                startX = e.getX();
                startY = e.getY();
                drawing = true;
                addShape(startX, startY, startX, startY);
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                if (drawing) {
                    if (trails) {
                        addShape(startX, startY, e.getX(), e.getY());
                    }
                    else {
                        updateLastShape(e.getX(), e.getY());
                    }
                    repaint();
                }
            }
        });

        addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                drawing = false;
            }
        });
    }

    private void addShape(int x1, int y1, int x2, int y2) {
        switch (currentShape) {
            case LINE -> shapes.add(new Line(x1, y1, x2, y2, currentColor));
            case BOX -> shapes.add(new Shapes.Box(x1, y1, x2, y2, currentColor));
            case OVAL -> shapes.add(new Oval(x1, y1, x2, y2, currentColor));
        }
        repaint();
    }

    private void updateLastShape(int x2, int y2) {
        if (!shapes.isEmpty() && !trails) {
            shapes.getLast().updateEnd(x2, y2);
        }
        repaint();
    }

    public void processKey(char key) {
        switch (Character.toUpperCase(key)) {
            case 'E' -> shapes.clear();
            case 'T' -> trails = !trails;
            case 'L' -> currentShape = ShapeType.LINE;
            case 'B' -> currentShape = ShapeType.BOX;
            case 'O' -> currentShape = ShapeType.OVAL;
            case 'C' -> currentColor = JColorChooser.showDialog(this, "Choose Color", currentColor);
            case 'S' -> saveShapes();
            case 'R' -> loadShapes();
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Shapes.Shape s : shapes) {
            s.draw(g);
        }

        g.setColor(Color.BLACK);
        g.drawString("Andrii Malakhovtsev", 10, 20);
        g.setFont(new Font("Serif", Font.BOLD, 16));
        g.drawString("(E)rase (T)rails (L)ine (B)ox (O)val (C)olor (S)ave (R)estore",
                DrawingApp.WIDTH / 2 - 200, DrawingApp.HEIGHT - 70);
    }

    // Phase 3
    private void saveShapes() {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Save Drawing");

        int userSelection = chooser.showSaveDialog(this);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(chooser.getSelectedFile()))) {
                out.writeObject(shapes);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void loadShapes() {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Open Drawing");

        int userSelection = chooser.showOpenDialog(this);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(chooser.getSelectedFile()))) {
                shapes = (LinkedList<Shapes.Shape>) in.readObject();
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }
}

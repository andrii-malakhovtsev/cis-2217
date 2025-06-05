import javax.swing.*;
import java.awt.event.*;

public class DrawingApp extends JFrame {
    public static int WIDTH = 800;
    public static int HEIGHT = 600;

    private DrawingCanvas canvas;

    public DrawingApp() {
        canvas = new DrawingCanvas();
        add(canvas);
        setTitle("Drawing Program - Shapes, Phase 2");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                canvas.processKey(e.getKeyChar());
            }
        });
    }

    public static void main(String[] args) {
        new DrawingApp();
    }
}

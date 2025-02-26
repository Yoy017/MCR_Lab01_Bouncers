import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GraphicalWindow implements Displayer {

    private static GraphicalWindow instance;
    private JFrame frame;
    private JPanel panel;

    private final int width = 500;
    private final int height = 600;

    private GraphicalWindow() {
//        setPreferredSize(new Dimension(500, 600));
        // update the board every DELAY ms
        frame = new JFrame("Bouncers");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        frame.setPreferredSize(new Dimension(width, height));
        frame.pack();
        frame.setContentPane(panel);
        frame.setVisible(true);
    }

    public static GraphicalWindow getInstance() {
        if (instance == null) {
            instance = new GraphicalWindow();
        }
        return instance;
    }

    public int getWidth() {
        return panel.getWidth();
    }

    public int getHeight() {
        return panel.getHeight();
    }

    public Graphics2D getGraphics() {
        return (Graphics2D) panel.getGraphics();
    }

    public void repaint() {
        panel.repaint();
    }

    public void setTitle(String title) {
        frame.setTitle(title);
    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//        for (Entity entity : entities)
//            entity.move(this);
//        repaint();
//    }
//
//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        for (Entity entity : entities)
//            entity.draw(g);
//    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class GraphicalWindow extends JPanel implements Displayer {

    private static GraphicalWindow instance;
    private JFrame frame;
    private JPanel panel;

    private final int width = 500;
    private final int height = 600;
    private List<Entity> entities;


    private GraphicalWindow() {
        // update the board every DELAY ms
        frame = new JFrame("Bouncers");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //panel = new JPanel();
        frame.setSize(width, height);
        frame.setPreferredSize(new Dimension(width, height));
        //frame.pack();
        frame.setContentPane(this);
        frame.setVisible(true);
    }

    public static GraphicalWindow getInstance() {
        if (instance == null) {
            instance = new GraphicalWindow();
        }
        return instance;
    }

    public int getWidth() {
        return frame.getWidth();
    }

    public int getHeight() {
        return frame.getHeight();
    }

    public Graphics2D getGraphics() {
        return (Graphics2D) super.getGraphics();
    }

    public void repaint() {
        super.repaint();
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
    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Entity entity : entities)
            entity.draw(g);
    }
}

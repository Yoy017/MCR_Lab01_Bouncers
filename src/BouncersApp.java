import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class BouncersApp implements ActionListener {

    private final LinkedList<Entity> bouncers = new LinkedList<>();
    /* added */
    private final int nbEntities = 50;
    private static final int DELAY = 20;
    private final Timer timer = new Timer(DELAY, this);

    public BouncersApp() { }

    public void run() {
        // Add entities
        for (int i = 0; i < nbEntities; i++) {
            Entity entity;
            if (Math.random() < 0.5)
                entity = new Square();
            else
                entity = new Circle();

            entity.x = (int) (Math.random() * GraphicalWindow.getInstance().getWidth());
            entity.y = (int) (Math.random() * GraphicalWindow.getInstance().getHeight());

            bouncers.add(entity);
        }

//        JFrame frame = new JFrame("Bouncers");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.add(GraphicalWindow.getInstance());
//        frame.pack();
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);


        timer.start();
    }


    public static void main(String[] args) {
        // thread safe
//        SwingUtilities.invokeLater(() -> {
//            JFrame frame = new JFrame("Bouncers");
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//            frame.add(new Board(50));
//
//            frame.pack();
//            frame.setLocationRelativeTo(null);
//            frame.setVisible(true);
//        });
        SwingUtilities.invokeLater(new BouncersApp()::run);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Entity entity : bouncers) {
            entity.move(GraphicalWindow.getInstance());
            entity.draw();
        }
        GraphicalWindow.getInstance().repaint();

    }

//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        for (Entity entity : bouncers)
//            entity.draw(g);
//    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//        for (Entity entity : bouncers)
//            entity.move(this);
//        repaint();
//    }
//
//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        for (Entity entity : bouncers)
//            entity.draw(g);
//    }
}
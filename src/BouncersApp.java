import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class BouncersApp {

    private final LinkedList<Entity> bouncers = new LinkedList<>();
    /* added */
    private final int nbEntities = 50;
    private static final int DELAY = 20;
   // private final Timer timer = new Timer(DELAY, this);

    public BouncersApp() {
        GraphicalWindow window = GraphicalWindow.getInstance();

        for (int i = 0; i < 50; i++) {
            Entity entity = Math.random() < 0.5 ? new Square() : new Circle();
            entity.x = (int) (Math.random() * window.getWidth());
            entity.y = (int) (Math.random() * window.getHeight());
            bouncers.add(entity);
        }

        window.setEntities(bouncers);
    }

    public void run() {
        // Add entities
        /*for (int i = 0; i < nbEntities; i++) {
            Entity entity;
            if (Math.random() < 0.5)
                entity = new Square();
            else
                entity = new Circle();

            entity.x = (int) (Math.random() * GraphicalWindow.getInstance().getWidth());
            entity.y = (int) (Math.random() * GraphicalWindow.getInstance().getHeight());

            bouncers.add(entity);
        }*/

        new Timer(DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Entity entity : bouncers) {
                    entity.move();
                    //entity.draw();
                }
                GraphicalWindow.getInstance().repaint();
            }
        }).start();
        //timer.start();
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new BouncersApp()::run);
    }

    /*@Override
    public void actionPerformed(ActionEvent e) {
        for (Entity entity : bouncers) {
            entity.move();
            //entity.draw();
        }
        GraphicalWindow.getInstance().repaint();
    }*/
}
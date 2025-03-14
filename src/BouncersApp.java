/**
 * CircleFull.java
 * @authors Bleuer Rémy, Changanaqui Yoann
 * 14.03.25
 * MCR-A
 */

import factory.FactoryAbstractShape;
import graphic.GraphicalWindow;
import shape.*;
import factory.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.LinkedList;

/**
 * @brief Main class of the Bouncers application.
 *
 * This class manages the list of entities, their creation and their animation.
 * It uses a Timer to periodically update the positions of the entities and
 * notify the graphical window of the changes.
 */
public class BouncersApp {
    // List of animated entities
    private final LinkedList<Bouncable> bouncers = new LinkedList<>();
    // Delay between two frames in milliseconds (33 ms is about 30 fps)
    private static final int DELAY = 33;
    // Number of entities to add at each press of the key
    private static final int ADD_ENTITIES = 10;
    // Timer to update the animation
    private Timer timer;

    /**
     * @brief Constructor of the BouncersApp class.
     *
     * This constructor initializes the graphical window and adds a KeyListener
     * to manage the key presses.
     */
    public BouncersApp() {
        GraphicalWindow window = GraphicalWindow.getInstance();
        window.setTitle("Bouncers");
        window.addKeyListenerToFrame(new BouncersKeyListener());
    }

    /**
     * @brief Create a number of entities using a factory.
     *
     * This method creates a number of entities using the given factory and
     * adds them to the list of entities.
     *
     * @param factory The factory to use to create the entities.
     */
    private void createShapes(FactoryAbstractShape factory) {
        for (int i = 0; i < ADD_ENTITIES; i++) {
            bouncers.add(factory.createCircle());
            bouncers.add(factory.createSquare());
        }
    }

    /**
     * @brief Clear the list of entities and repaint the window.
     */
    private void clearShapes() {
        bouncers.clear();
        GraphicalWindow.getInstance().repaint();
    }

    /**
     * @brief Stop the timer and the application.
     */
    private void stop() {
        if (timer != null) {
            timer.stop();
        }
        System.exit(0);
    }

    /**
     * @brief Run the application.
     *
     * This method starts the timer and the animation loop.
     */
    public void run() {
        timer = new Timer(DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               updateAndRenderShapes();
            }
        });
        timer.start();
    }

    /**
     * @brief Update the positions of the entities and repaint the window.
     *
     * Without separating the move and draw and clearing the buffer in between,
     * the entities wouls flicker
     */
    private void updateAndRenderShapes() {
        // Update the position of each entity
        for (Bouncable b : bouncers) {
            b.move();
        }

        // clear the buffer
        GraphicalWindow window = GraphicalWindow.getInstance();
        window.clearBuffer();

        // draw entities
        for (Bouncable b : bouncers) {
            b.draw();
        }

        // repaint the window
        window.repaint();
    }

    /**
     * @brief Main method of the Bouncers application.
     *
     * This method creates an instance of the BouncersApp class and runs it.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        new BouncersApp().run();
    }

    /**
     * @brief BouncersKeyListener class to manage the key presses.
     */
    private class BouncersKeyListener extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_E:
                    clearShapes();
                    break;
                case KeyEvent.VK_F:
                    createShapes(FactoryFull.getInstance());
                    break;
                case KeyEvent.VK_B:
                    createShapes(FactoryBorder.getInstance());
                    break;
                case KeyEvent.VK_Q:
                    stop();
                    break;
            }
        }
    }
}
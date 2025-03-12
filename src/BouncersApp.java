import factory.FactoryAbstractShape;
import graphic.GraphicalWindow;
import shape.*;
import factory.*;

import javax.swing.*;
import java.awt.event.*;
import java.util.LinkedList;

/**
 * @brief Classe principale de l'application Bouncers.
 *
 * Cette classe gère la liste des entités, leur création et leur animation.
 * Elle utilise un Timer pour mettre à jour périodiquement les positions
 * des entités et notifier la fenêtre graphique des changements.
 */
public class BouncersApp {
    /** Liste des entités animées */
    private final LinkedList<Bouncable> bouncers = new LinkedList<>();

    /** Délai entre les mises à jour en millisecondes */
    private static final int DELAY = 33;

    /** Nombre d'entités à créer */
    private static final int ADD_ENTITIES = 10;

    private Timer timer;

    public BouncersApp() {
        // Ajoute un KeyListener pour gérer les touches
        GraphicalWindow window = GraphicalWindow.getInstance();
        window.setTitle("Bouncers");
        window.addKeyListenerToFrame(new BouncersKeyListener());
    }

    // Ajouter des entités à la liste
    private void createShapes(FactoryAbstractShape factory) {
        for (int i = 0; i < ADD_ENTITIES; i++) {
            bouncers.add(factory.createCircle());
            bouncers.add(factory.createSquare());
        }
    }

    private void clearShapes() {
        bouncers.clear();
        GraphicalWindow.getInstance().repaint();
    }

    private void stop() {
        if (timer != null) {
            timer.stop();
        }
        System.exit(0);
    }

    public void run() {
        timer = new Timer(DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               updateAndRenderShapes();
            }
        });
        timer.start();
    }

    private void updateAndRenderShapes() {
        for (Bouncable b : bouncers) {
            b.move();
        }

        GraphicalWindow window = GraphicalWindow.getInstance();
        window.clearBuffer();

        for (Bouncable b : bouncers) {
            b.draw();
        }
        
        window.repaint(); // Demande un rafraîchissement
    }

    public static void main(String[] args) {
        new BouncersApp().run();
    }

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
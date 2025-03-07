import factory.FactoryAbstractShape;
import graphic.DefaultRenderer;
import graphic.GraphicalWindow;
import graphic.Renderer;
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
    private static final int DELAY = 20;

    /** Nombre d'entités à créer */
    private static final int ADD_ENTITIES = 10;

    private final FactoryAbstractShape factoryFull;
    private final FactoryAbstractShape factoryBorder;

    private Timer timer;

    public BouncersApp() {
        // Créer les entités
        Renderer renderer = new DefaultRenderer(true);
        factoryFull = new FactoryFull();
        factoryBorder = new FactoryBorder();
        // Ajoute un KeyListener pour gérer les touches
        GraphicalWindow.getInstance().addKeyListenerToFrame(new BouncersKeyListener());
    }

    // Ajouter des entités à la liste
    private void createFullShape() {
        for (int i = 0; i < ADD_ENTITIES; i++) {
            Renderer rendererFull = new DefaultRenderer(true);
            bouncers.add(factoryFull.createCircle(rendererFull));
            bouncers.add(factoryFull.createSquare(rendererFull));
        }
    }

    private void createBorderShape() {
        for (int i = 0; i < ADD_ENTITIES; i++) {
            Renderer rendererBorder = new DefaultRenderer(false);
            bouncers.add(factoryBorder.createCircle(rendererBorder));
            bouncers.add(factoryBorder.createSquare(rendererBorder));
        }
    }

    private void clearShapes() {
        bouncers.clear();
        GraphicalWindow.getInstance().update();
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
                for (Bouncable b : bouncers) {
                    b.move();
                    b.draw();
                }
                GraphicalWindow.getInstance().update(); // Demande un rafraîchissement
            }
        });
        timer.start();
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
                    createFullShape();
                    break;
                case KeyEvent.VK_B:
                    createBorderShape();
                    break;
                case KeyEvent.VK_Q:
                    stop();
                    break;
            }
        }
    }
}
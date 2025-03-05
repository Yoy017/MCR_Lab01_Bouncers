import graphic.BouncersPanel;
import graphic.GraphicalWindow;
import shape.*;
import shape.circle.CircleFull;
import shape.square.SquareFull;

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
    private final LinkedList<Entity> bouncers = new LinkedList<>();

    /** Délai entre les mises à jour en millisecondes */
    private static final int DELAY = 20;

    /** Nombre d'entités à créer */
    private static final int nbBouncers = 50;

    /** Panneau personnalisé pour le dessin des entités */
    private final BouncersPanel bouncersPanel;

    public BouncersApp() {
        // Créer les entités
        createEntities(800, 600); // Dimensions initiales par défaut

        // Créer un panel pour les dessiner
        bouncersPanel = new BouncersPanel(bouncers);

        // Associer le panel à la fenêtre
        GraphicalWindow.getInstance().setPanel(bouncersPanel);

        // Ajoute un KeyListener pour gérer les touches
        GraphicalWindow.getInstance().addKeyListenerToFrame(new BouncersKeyListener());
    }

    // Ajoute 'nbBouncers' entités dans la liste d'entités
    private void createEntities(int width, int height) {
        for (int i = 0; i < nbBouncers; i++) {
            Entity entity = Math.random() < 0.5 ? new SquareFull() : new CircleFull();
            entity.x((int) (Math.random() * width));
            entity.y((int) (Math.random() * height));
            bouncers.add(entity);
        }
    }

    public void run() {
        Timer timer = new Timer(DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Entity entity : bouncers) {
                    entity.move();
                }
                GraphicalWindow.getInstance().update(); // Demande un rafraîchissement
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BouncersApp().run();
        });
    }

    private static class BouncersKeyListener extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_E:
                    System.out.println("E");
                    break;
                case KeyEvent.VK_F:

                    break;
                case KeyEvent.VK_B:

                    break;
                case KeyEvent.VK_Q:

                    break;
            }
        }

    }

}
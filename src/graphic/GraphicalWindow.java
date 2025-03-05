package graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import shape.*;

/**
 * @brief Fenêtre graphique pour l'affichage des entités.
 *
 * Cette classe implémente les interfaces graphic.Displayer et graphic.EntityObserver
 * et utilise le pattern Singleton pour assurer une instance unique.
 * Elle gère la fenêtre Swing et délègue l'affichage à un JPanel.
 */
public class GraphicalWindow implements Displayer, EntityObserver {
    /* Instance unique (pattern Singleton) */
    private static GraphicalWindow instance;
    private JFrame frame;
    private JPanel panel;

    private GraphicalWindow() {
        frame = new JFrame("Bouncers");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null); // Center on screen

        // Create a default panel initially
        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        frame.setContentPane(panel);

        frame.setVisible(true);

//        frame.addComponentListener(new ComponentAdapter() {
//            @Override
//            public void componentResized(ComponentEvent e) {
//                frame.revalidate();
//                frame.repaint();
//            }
//        });
    }

    /**
     * @brief Obtient l'instance unique de la fenêtre graphique.
     * @return L'instance unique de graphic.GraphicalWindow
     */
    public static GraphicalWindow getInstance() {
        if (instance == null) {
            instance = new GraphicalWindow();
        }
        return instance;
    }

    /**
     * @brief Définit le panneau d'affichage.
     * @param newPanel Nouveau panneau à utiliser pour l'affichage
     */
    public void setPanel(JPanel newPanel) {
        this.panel = newPanel;
        frame.setContentPane(panel);
        frame.revalidate();
    }

    @Override
    public int getWidth() {
        return panel.getWidth();
    }

    @Override
    public int getHeight() {
        return panel.getHeight();
    }

    /**
     * @brief Obtient le contexte graphique du panneau.
     * @return Un objet Graphics2D pour le dessin
     */
    @Override
    public Graphics2D getGraphics() {
        return (Graphics2D) panel.getGraphics();
    }

    /**
     * @brief Demande un rafraîchissement du panneau.
     */
    @Override
    public void repaint() {
        if (panel != null) {
             GraphicalWindow.getInstance().panel.repaint();
        }
    }

    @Override
    public void setTitle(String title) {
        frame.setTitle(title);
    }

    /**
     * @brief Méthode de l'interface graphic.EntityObserver appelée lors des mises à jour.
     *
     * Cette méthode est appelée pour notifier la fenêtre que l'état des entités
     * a changé et qu'un rafraîchissement est nécessaire.
     */
    @Override
    public void update() {
        this.repaint();
    }
}
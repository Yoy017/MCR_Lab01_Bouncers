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
    private Image buffer;

    private GraphicalWindow() {
        frame = new JFrame("Bouncers");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null); // Center on screen

        // Create a default panel initially
        panel = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (buffer != null) {
                    g.drawImage(buffer, 0, 0, this);
                }
            }
        };

        JLabel label = new JLabel("<html>" +
                "- Press F to add full shapes<br />" +
                "- Press B to add border shapes<br />" +
                "- Press E to clear shapes<br />" +
                "- Press Q to quit" +
                "</html>");
        label.setForeground(Color.LIGHT_GRAY);

        panel.add(label, new GridBagConstraints());
        panel.setBackground(Color.WHITE);

        frame.setContentPane(panel);
        frame.setVisible(true);

        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                buffer = panel.createImage(panel.getWidth(), panel.getHeight());
                frame.revalidate();
                frame.repaint();
            }
        });
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
        buffer = panel.createImage(panel.getWidth(), panel.getHeight());
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
        if(buffer == null) {
            buffer = panel.createImage(panel.getWidth(), panel.getHeight());
        }
        Graphics2D g2 = (Graphics2D) buffer.getGraphics();
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, panel.getWidth(), panel.getHeight());
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
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

    public void addKeyListenerToFrame(KeyListener listener) {
        frame.addKeyListener(listener);
        frame.requestFocus();
    }
}
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
public class GraphicalWindow implements Displayer {
    /* Instance unique (pattern Singleton) */
    private static GraphicalWindow instance;
    private JFrame frame;
    private JPanel panel;
    private Image buffer;
    private Graphics2D g2Buffer;

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

        buffer = createNewBuffer();

        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                buffer = createNewBuffer();
            }
        });
    }

    private Image createNewBuffer() {
        Image newBuffer = panel.createImage(panel.getWidth(), panel.getHeight());
        if (newBuffer != null) {
            g2Buffer = (Graphics2D) newBuffer.getGraphics();
            g2Buffer.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        }
        return newBuffer;
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
        if(buffer == null || g2Buffer == null) {
            buffer = createNewBuffer();
        }

        return g2Buffer;
    }

    public void clearBuffer() {
        if (g2Buffer != null) {
            g2Buffer.setColor(Color.WHITE);
            g2Buffer.fillRect(0, 0, panel.getWidth(), panel.getHeight());
        }
    }

    /**
     * @brief Demande un rafraîchissement du panneau.
     */
    @Override
    public void repaint() {
        if (panel != null) {
             panel.repaint();
        }
    }

    @Override
    public void setTitle(String title) {
        frame.setTitle(title);
    }

    public void addKeyListenerToFrame(KeyListener listener) {
        frame.addKeyListener(listener);
        frame.requestFocus();
    }
}
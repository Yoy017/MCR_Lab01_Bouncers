/**
 * GraphicalWindow.java
 * @authors Bleuer Rémy, Changanaqui Yoann
 * 14.03.25
 * MCR-A
 */

package graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @brief Graphic window for displaying entities.
 *
 * This class implements the graphic.Displayer interfaces
 * and uses the Singleton pattern to ensure a unique instance.
 * It manages the Swing window and delegates the display to a JPanel.
 */
public class GraphicalWindow implements Displayer {
    private static GraphicalWindow instance;
    private JFrame frame;
    private JPanel panel;
    private Image buffer;
    private Graphics2D g2Buffer;

    /**
     * @brief Constructeur privé de la fenêtre graphique.
     */
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

        // Add a label with instructions
        JLabel label = new JLabel("<html>" +
                "- Press F to add full shapes<br />" +
                "- Press B to add border shapes<br />" +
                "- Press E to clear shapes<br />" +
                "- Press Q to quit" +
                "</html>");
        label.setForeground(Color.LIGHT_GRAY);

        // Add the label to the panel and ceneter it
        panel.add(label, new GridBagConstraints());
        panel.setBackground(Color.WHITE);

        frame.setContentPane(panel);
        frame.setVisible(true);

        // Create a new buffer
        buffer = createNewBuffer();

        // Resize the buffer when the window is resized
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                buffer = createNewBuffer();
            }
        });
    }

    /**
     * @brief Create a new buffer for the panel.
     * @return New image buffer
     */
    private Image createNewBuffer() {
        // Create a new buffer with the same size as the panel
        Image newBuffer = panel.createImage(panel.getWidth(), panel.getHeight());

        // get the graphics context of the new buffer
        if (newBuffer != null) {
            g2Buffer = (Graphics2D) newBuffer.getGraphics();
            g2Buffer.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        }
        return newBuffer;
    }

    /**
     * @return The unique instance of graphic.GraphicalWindow
     */
    public static GraphicalWindow getInstance() {
        if (instance == null) {
            instance = new GraphicalWindow();
        }
        return instance;
    }

    /**
     * @return The width of the panel
     */
    @Override
    public int getWidth() {
        return panel.getWidth();
    }

    /**
     * @return The height of the panel
     */
    @Override
    public int getHeight() {
        return panel.getHeight();
    }

    /**
     * @return A Graphics2D object for drawing
     */
    @Override
    public Graphics2D getGraphics() {
        if(buffer == null || g2Buffer == null) {
            // new buffer if not already created
            buffer = createNewBuffer();
        }
        return g2Buffer;
    }

    /**
     * @brief Clear the buffer with a white color.
     */
    public void clearBuffer() {
        if (g2Buffer != null) {
            g2Buffer.setColor(Color.WHITE);
            g2Buffer.fillRect(0, 0, panel.getWidth(), panel.getHeight());
        }
    }

    /**
     * @brief Request a repaint of the panel.
     */
    @Override
    public void repaint() {
        if (panel != null) {
             panel.repaint();
        }
    }

    /**
     * @brief Set the title of the window.
     * @param title The new title
     */
    @Override
    public void setTitle(String title) {
        frame.setTitle(title);
    }

    /**
     * @brief Add a key listener to the frame.
     * @param listener The key listener to add
     */
    public void addKeyListenerToFrame(KeyListener listener) {
        frame.addKeyListener(listener);
        frame.requestFocus();
    }
}
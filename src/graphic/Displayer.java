package graphic;

import java.awt.*;

/**
 * @brief Displayer interface to get display information.
 */
public interface Displayer {
    int getWidth();
    int getHeight();
    Graphics2D getGraphics();
    void repaint();
    void setTitle(String title);
}

package graphic;

import shape.Bouncable;
import java.awt.Graphics2D;

/**
 * @brief Renderer interface to display the graphic.
 */
public interface Renderer {
    void display(Graphics2D g, Bouncable b);
}
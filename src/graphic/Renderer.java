package graphic;

import shape.Bouncable;
import java.awt.Graphics2D;

/**
 * @brief Renderer interface to display the graphic.
 */
public interface Renderer {

    /**
     * @brief Display the graphic.
     * @param g The Graphics2D object.
     * @param b The Bouncable object.
     */
    void display(Graphics2D g, Bouncable b);
}
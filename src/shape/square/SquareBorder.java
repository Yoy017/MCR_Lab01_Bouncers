/**
 * SquareBorder.java
 * @authors Bleuer Rémy, Changanaqui Yoann
 * 14.03.25
 * MCR-A
 */

package shape.square;

import graphic.Renderer;
import graphic.RendererBorder;
import java.awt.*;

/**
 * @brief SquareBorder class to create a square with a border.
 */
public class SquareBorder extends Square {
    public SquareBorder() {
        super(Color.RED);
    }

    // return the renderer for shapes with a border
    @Override
    protected Renderer getRenderer() {
        return RendererBorder.getInstance();
    }
}

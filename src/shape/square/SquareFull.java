/**
 * SquareFull.java
 * @authors Bleuer Rémy, Changanaqui Yoann
 * 14.03.25
 * MCR-A
 */

package shape.square;

import graphic.Renderer;
import graphic.RendererFull;
import java.awt.*;

/**
 * @brief SquareFull class to create a square with a full color.
 */
public class SquareFull extends Square {
    public SquareFull() {
        super(Color.ORANGE);
    }

    // return the renderer for shapes with a full color
    protected Renderer getRenderer() {
        return RendererFull.getInstance();
    }
}

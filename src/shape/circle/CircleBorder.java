/**
 * CircleBorder.java
 * @authors Bleuer Rémy, Changanaqui Yoann
 * 14.03.25
 * MCR-A
 */

package shape.circle;

import graphic.Renderer;
import graphic.RendererBorder;
import java.awt.*;

/**
 * @brief CircleBorder class to create a circle with a border.
 */
public class CircleBorder extends Circle {
    public CircleBorder() {
        super(Color.GREEN);
    }

    // return the renderer for shapes with a border
    @Override
    protected Renderer getRenderer() {
        return RendererBorder.getInstance();
    }
}

/**
 * CircleFull.java
 * @authors Bleuer Rémy, Changanaqui Yoann
 * 14.03.25
 * MCR-A
 */

package shape.circle;

import graphic.RendererFull;
import graphic.Renderer;
import java.awt.*;

/**
 * @brief CircleFull class to create a circle with a full color.
 */
public class CircleFull extends Circle {

    public CircleFull() {
        super(Color.BLUE);
    }

    // return the renderer for shapes with a full color
    protected Renderer getRenderer() {
        return RendererFull.getInstance();
    }
}

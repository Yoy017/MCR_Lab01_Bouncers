/**
 * RendererFull.java
 * @authors Bleuer Rémy, Changanaqui Yoann
 * 14.03.25
 * MCR-A
 */

package graphic;

import shape.Bouncable;
import java.awt.*;

/**
 * @brief RendererFull class to render a shape with a full color.
 */
public class RendererFull implements Renderer {

    // singleton
    private static RendererFull instance;

    // new instance if not already created
    public static RendererFull getInstance() {
        if(instance == null) {
            instance = new RendererFull();
        }
        return instance;
    }

    @Override
    public void display(Graphics2D g, Bouncable b) {
        if (g != null) {
            g.setColor(b.getColor());
            // antialiasing
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            // fill the shape
            g.fill(b.getShape());
        }
    }
}

/**
 * RendererBorder.java
 * @authors Bleuer Rémy, Changanaqui Yoann
 * 14.03.25
 * MCR-A
 */

package graphic;

import shape.Bouncable;
import java.awt.*;

/**
 * @brief RendererBorder class to render a shape with a border.
 */
public class RendererBorder implements Renderer {
    // singleton
    private static RendererBorder instance;

    // new instance if not already created
    public static RendererBorder getInstance() {
        if(instance == null) {
            instance = new RendererBorder();
        }
        return instance;
    }

    @Override
    public void display(Graphics2D g, Bouncable b) {
        if (g != null) {
            g.setColor(b.getColor());

            // antialiasing
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // draw the border
            g.setStroke(new BasicStroke(2));
            g.draw(b.getShape());
        }
    }
}

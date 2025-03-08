package graphic;

import shape.Bouncable;
import java.awt.*;

public class DefaultRenderer implements Renderer {
    private final boolean isFilled;

    public DefaultRenderer(boolean isFilled) {
        this.isFilled = isFilled;
    }

    @Override
    public void display(Graphics2D g, Bouncable b) {
        if (g != null) {
            g.setColor(b.getColor());

            // antialiasing
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            if(isFilled)
                g.fill(b.getShape());
            else {
                g.setStroke(new BasicStroke(2));
                g.draw(b.getShape());
            }
        }
    }
}

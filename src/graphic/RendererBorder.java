package graphic;

import shape.Bouncable;
import java.awt.*;

public class RendererBorder implements Renderer {

    private static RendererBorder instance;

    public RendererBorder() {
    }

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

            g.setStroke(new BasicStroke(2));
            g.draw(b.getShape());
        }
    }
}

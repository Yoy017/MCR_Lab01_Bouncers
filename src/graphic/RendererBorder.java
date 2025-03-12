package graphic;

import shape.Bouncable;
import java.awt.*;

public class RendererBorder implements Renderer {

    public RendererBorder() {
    }

    private static class InstanceHolder {
        private static final RendererBorder instance = new RendererBorder();
    }

    public static RendererBorder getInstance() {
        return InstanceHolder.instance;
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

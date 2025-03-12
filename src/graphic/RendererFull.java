package graphic;

import shape.Bouncable;

import java.awt.*;

public class RendererFull implements Renderer {

    private static RendererFull instance;

    private RendererFull() {
    }

//    private static class InstanceHolder {
//        private static final RendererFull instance = new RendererFull();
//    }

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
            g.fill(b.getShape());
        }
    }
}

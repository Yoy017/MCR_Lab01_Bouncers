package shape.circle;

import graphic.RendererFull;
import shape.AbstractShape;
import graphic.Renderer;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class CircleFull extends Circle {

    public CircleFull() {
        super(Color.BLUE);
    }

    protected Renderer getRenderer() {
        return RendererFull.getInstance();
    }
}

package shape.circle;

import graphic.Renderer;
import graphic.RendererFull;
import shape.AbstractShape;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class SquareFull extends Square {
    public SquareFull() {
        super(Color.ORANGE);
    }

    protected Renderer getRenderer() {
        return RendererFull.getInstance();
    }
}

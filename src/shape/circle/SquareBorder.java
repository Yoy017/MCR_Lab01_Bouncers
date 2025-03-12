package shape.circle;

import graphic.Renderer;
import graphic.RendererBorder;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class SquareBorder extends Square {
    public SquareBorder() {
        super(Color.RED);
    }

    @Override
    protected Renderer getRenderer() {
        return RendererBorder.getInstance();
    }
}

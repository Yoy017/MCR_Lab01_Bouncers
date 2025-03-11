package shape.square;

import graphic.Renderer;
import shape.AbstractShape;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class SquareFull extends AbstractShape {
    public SquareFull(Renderer renderer) {
        super(Color.ORANGE, renderer);
    }

    @Override
    public Shape getShape() {
        return new Rectangle2D.Double(x, y, size, size);
    }
}

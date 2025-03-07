package shape.square;

import shape.AbstractShape;
import graphic.Renderer;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class SquareBorder extends AbstractShape {
    public SquareBorder(Renderer renderer) {
        super(Color.RED, renderer);
    }

    @Override
    public Shape getShape() {
        return new Rectangle2D.Double(x, y, size, size);
    }
}

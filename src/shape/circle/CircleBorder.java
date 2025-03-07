package shape.circle;

import shape.AbstractShape;
import graphic.Renderer;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class CircleBorder extends AbstractShape {
    public CircleBorder(Renderer renderer) {
        super(Color.GREEN, renderer);
    }

    @Override
    public Shape getShape() {
        return new Ellipse2D.Double(x, y, size, size);
    }
}

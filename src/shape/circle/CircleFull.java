package shape.circle;

import shape.AbstractShape;
import graphic.Renderer;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class CircleFull extends AbstractShape {

    public CircleFull(Renderer renderer) {
        super(Color.BLUE, renderer);
    }

    @Override
    public Shape getShape() {
        return new Ellipse2D.Double(x, y, size, size);
    }
}

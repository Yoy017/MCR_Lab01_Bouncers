package shape.circle;

import shape.AbstractShape;
import shape.Bouncable;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public abstract class Circle extends AbstractShape {

    public Circle(Color color) {
        super(color);
    }

    @Override
    public Shape getShape() {
        return new Ellipse2D.Double(x, y, size, size);
    }
}

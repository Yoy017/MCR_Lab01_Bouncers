package shape.circle;

import shape.AbstractShape;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public abstract class Square extends AbstractShape {
    public Square(Color color) {
        super(color);
    }

    @Override
    public Shape getShape() {
        return new Rectangle2D.Double(x, y, size, size);
    }
}

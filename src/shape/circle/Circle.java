/**
 * Cirlce.java
 * @authors Bleuer Rémy, Changanaqui Yoann
 * 14.03.25
 * MCR-A
 */

package shape.circle;

import shape.AbstractShape;
import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * @brief Abstract class Circle to create a basic circle.
 */
public abstract class Circle extends AbstractShape {

    public Circle(Color color) {
        super(color);
    }

    // return a circle
    @Override
    public Shape getShape() {
        return new Ellipse2D.Double(x, y, size, size);
    }
}

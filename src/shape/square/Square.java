/**
 * Square.java
 * @authors Bleuer Rémy, Changanaqui Yoann
 * 14.03.25
 * MCR-A
 */

package shape.square;

import shape.AbstractShape;
import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * @brief Abstract class Square to create a basic square.
 */
public abstract class Square extends AbstractShape {
    public Square(Color color) {
        super(color);
    }

    // return a square
    @Override
    public Shape getShape() {
        return new Rectangle2D.Double(x, y, size, size);
    }
}

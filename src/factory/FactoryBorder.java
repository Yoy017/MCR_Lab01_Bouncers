/**
 * FactoryBorder.java
 * @authors Bleuer Rémy, Changanaqui Yoann
 * 14.03.25
 * MCR-A
 */

package factory;

import shape.Bouncable;
import shape.circle.CircleBorder;
import shape.square.SquareBorder;

/**
 * @brief FactoryBorder class to create a square and a circle with a border.
 */
public class FactoryBorder implements FactoryAbstractShape {
    // singleton
    private static FactoryBorder instance;

    // new instance if not already created
    public static FactoryBorder getInstance() {
        if (instance == null) {
            instance = new FactoryBorder();
        }
        return instance;
    }

    @Override
    public Bouncable createCircle() {
        return new CircleBorder();
    }

    @Override
    public Bouncable createSquare() {
        return new SquareBorder();
    }
}

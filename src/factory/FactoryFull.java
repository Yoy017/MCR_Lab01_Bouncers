/**
 * FactoryFull.java
 * @authors Bleuer Rémy, Changanaqui Yoann
 * 14.03.25
 * MCR-A
 */

package factory;

import shape.Bouncable;
import shape.circle.CircleFull;
import shape.square.SquareFull;

/**
 * @brief FactoryFull class to create a square and a circle with a full color.
 */
public class FactoryFull implements FactoryAbstractShape {
    // singleton
    private static FactoryFull instance;

    // new instance if not already created
    public static FactoryFull getInstance() {
        if (instance == null) {
            instance = new FactoryFull();
        }
        return instance;
    }

    @Override
    public Bouncable createCircle() {
        return new CircleFull();
    }

    @Override
    public Bouncable createSquare() {
        return new SquareFull();
    }
}

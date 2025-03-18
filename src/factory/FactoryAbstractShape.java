/**
 * FactoryAbstractShape.java
 * @authors Bleuer Rémy, Changanaqui Yoann
 * 14.03.25
 * MCR-A
 */

package factory;

import shape.Bouncable;

/**
 * @brief Interface FactoryAbstractShape to create a square and a circle.
 */
public interface FactoryAbstractShape {
    /**
     * @brief Create a square.
     * @return The square.
     */
    Bouncable createSquare();

    /**
     * @brief Create a circle.
     * @return The circle.
     */
    Bouncable createCircle();
}

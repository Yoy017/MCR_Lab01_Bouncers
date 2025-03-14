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
    Bouncable createSquare();
    Bouncable createCircle();
}

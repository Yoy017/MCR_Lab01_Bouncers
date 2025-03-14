package shape;

import java.awt.*;

/**
 * @brief Bouncable interface to draw and move a buncable shape.
 */
public interface Bouncable {
    void draw();
    void move();
    Color getColor();
    Shape getShape();
}
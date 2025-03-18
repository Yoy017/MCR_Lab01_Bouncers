package shape;

import java.awt.*;

/**
 * @brief Bouncable interface to draw and move a buncable shape.
 */
public interface Bouncable {
    /**
     * @brief Draw the shape on the screen.
     */
    void draw();

    /**
     * @brief Move the shape on the screen.
     */
    void move();

    /**
     * @brief Get the color of the shape.
     * @return The color of the shape.
     */
    Color getColor();

    /**
     * @brief Get the shape.
     * @return The shape.
     */
    Shape getShape();
}
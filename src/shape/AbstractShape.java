/**
 * AbstractShape.java
 * @authors Bleuer Rémy, Changanaqui Yoann
 * 14.03.25
 * MCR-A
 */

package shape;

import graphic.GraphicalWindow;
import graphic.Renderer;
import java.awt.*;

/**
 * @brief Abstract class representing a graphical entity in motion.
 *
 * This class defines the basic behavior of an entity that can
 * move in a window and bounce off the edges.
 */
abstract public class AbstractShape implements Bouncable {
    protected Color color;
    protected int size;
    protected int x;
    protected int y;
    protected DirectionVector movement;

    /**
     * @brief Constructor for an AbstractShape
     * @param color The color of the shape
     */
    protected AbstractShape(Color color) {
        this.color = color;
        this.size = (int) (Math.random() * 5) + 15; // random size between 5 and 20 px

        // random initial position
        GraphicalWindow window = GraphicalWindow.getInstance();
        int maxWidth = window.getWidth() - size;
        int maxHeight = window.getHeight() - size;

        // positive size
        maxWidth = Math.max(1, maxWidth);
        maxHeight = Math.max(1, maxHeight);

        // random position
        this.x = (int) (Math.random() * maxWidth);
        this.y = (int) (Math.random() * maxHeight);

        // vector of movement
        this.movement = DirectionVector.randomDirection(1, 5); // random speed between 1 and 5
    }

    /**
     * @brief Move the entity and handle the bounces on the window edges.
     *
     * This method updates the position of the entity according to its speed
     * and reverses the speed components when the entity reaches an edge.
     */
    public void move() {
        GraphicalWindow panel = GraphicalWindow.getInstance();
        int panelWidth = panel.getWidth();
        int panelHeight = panel.getHeight();

        // update position
        y += (int) movement.getY();
        x += (int) movement.getX();

        // bounce on edges
        // if shape is out of bounds, move it back and reverse the speed
        if (y <= 0) {
            y = 0;
            movement.setY(-movement.getY());
        } else if (y + size >= panelHeight) {
            y = panelHeight - size;
            movement.setY(-movement.getY());
        }

        // same for x
        if (x <= 0) {
            x = 0;
            movement.setX(-movement.getX());
        } else if (x + size >= panelWidth) {
            x = panelWidth - size;
            movement.setX(-movement.getX());
        }
    }

    /**
     * @return the renderer for the shape (either full or outline)
     */
    protected abstract Renderer getRenderer();

    /**
     * @brief Draw the shape on the window using the renderer
     */
    @Override
    public void draw()  {
         getRenderer().display(GraphicalWindow.getInstance().getGraphics(), this);
    };

    /**
     * @return The color of the shape
     */
    @Override
    public Color getColor() {
        return color;
    }
}
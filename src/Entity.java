import javax.swing.*;
import java.awt.*;

abstract public class Entity extends JComponent {
    protected Color color;
    protected int size, x, y;
    protected DirectionVector movement;

    protected Entity(Color color) {
        this.color = color;
        this.size = (int) (Math.random() * 5) + 15; // random size between 5 and 20 px
        // initial position
        this.x = 0;
        this.y = 0;
        // vector of movement
        this.movement = DirectionVector.randomDirection(1, 5);
    }

    public void move(GraphicalWindow panel) {
        int panelWidth = panel.getWidth();
        int panelHeight = panel.getHeight();

        y += (int) movement.dy;
        x += (int) movement.dx;
        if(y <= 0 || y + size >= panelHeight) movement.invertY();
        if(x <= 0 || x + size >= panelWidth) movement.invertX();
    }

    public abstract void draw();
}
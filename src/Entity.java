import javax.swing.*;
import java.awt.*;
import java.util.Random;

abstract public class Entity extends JComponent {
    protected Color color;
    protected int size, x, y, dx, dy;
    private static final int SPEED = 1;
    private static final Random random = new Random();

    protected Entity(Color color) {
        this.color = color;
        this.size = random.nextInt(10) + 10; // random size between 10 and 20
        // initial position
        this.x = 0;
        this.y = 0;
        // random speed but not working for now
        // TODO
        this.dx = random.nextInt(1) + 1;
        this.dy = random.nextInt(1) + 1;
        // random direction
        if (random.nextBoolean()) dx = -dx;
        if (random.nextBoolean()) dy = -dy;
    }

    public void move(JPanel panel) {
        int panelWidth = panel.getWidth();
        int panelHeight = panel.getHeight();

        y += dy;
        x += dx;
        if(y <= 0 || y + size >= panelHeight) dy = -dy;
        if(x <= 0 || x + size >= panelWidth) dx = -dx;
    }

    public abstract void draw(Graphics g);
}
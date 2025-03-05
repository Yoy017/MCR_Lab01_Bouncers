package shape.circle;

import shape.Entity;

import java.awt.*;

public class CircleBorder extends Entity {
    public CircleBorder() {
        super(Color.RED);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.drawOval(x, y, size, size);
    }
}

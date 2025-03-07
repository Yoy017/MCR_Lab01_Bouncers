package shape.circle;

import shape.Entity;

import java.awt.*;

public class CircleBorder extends Entity {
    public CircleBorder() {
        super(Color.GREEN);
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(color);
        g.setStroke(new BasicStroke(2));
        g.drawOval(x, y, size, size);
    }
}

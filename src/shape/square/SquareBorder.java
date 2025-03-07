package shape.square;

import shape.Entity;

import java.awt.*;

public class SquareBorder extends Entity {
    public SquareBorder() {
        super(Color.RED);
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(color);
        g.setStroke(new BasicStroke(2));
        g.drawRect(x, y, size, size);
    }
}

package shape.square;

import shape.Entity;

import java.awt.*;

public class SquareBorder extends Entity {
    public SquareBorder() {
        super(Color.RED);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, size, size);
    }
}

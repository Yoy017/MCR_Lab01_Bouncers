package shape.square;

import shape.Entity;

import java.awt.*;

public class SquareFull extends Entity {
    public SquareFull() {
        super(Color.ORANGE);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, size, size);
    }
}

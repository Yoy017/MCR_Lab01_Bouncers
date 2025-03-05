package shape;

import java.awt.*;

public class CircleFull extends Entity {
    public CircleFull() {
        super(Color.BLUE);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, size, size);
    }
}

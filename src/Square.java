import java.awt.*;

public class Square extends Entity {
    public Square() {
        super(Color.YELLOW);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, size, size);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, size, size);
    }
}

import java.awt.*;

public class Circle extends Entity {
    public Circle() {
        super(Color.BLUE);
    }

    @Override
    public void draw() {
        Graphics g = GraphicalWindow.getInstance().getGraphics();
        g.setColor(color);
        g.fillOval(x, y, size, size);
        g.setColor(Color.BLACK);
        g.drawOval(x, y, size, size);
    }
}

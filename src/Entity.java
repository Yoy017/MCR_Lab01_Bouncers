import javax.swing.*;
import java.awt.*;

abstract public class Entity extends JComponent {
    final protected Color color;
    final protected int max_size = 5, size;
//    final protected Position startPos;
//    final protected Position direction;

    protected Entity(Color color, int s) {
        this.color = color;
        if(s >= max_size)
            this.size = max_size;
        else
            this.size = s;
    }

    public int getEntitySize() { return this.size; }
}

class Square extends Entity {

    public Square(int s) {
        super(Color.yellow, s);
    }
}

class Circle extends Entity {

    public Circle(int d) {
        super(Color.blue, d);
    }

}
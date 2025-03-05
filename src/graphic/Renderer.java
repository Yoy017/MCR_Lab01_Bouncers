package graphic;

import shape.Bouncable;
import java.awt.Graphics2D;

public interface Renderer {
    void display(Graphics2D g, Bouncable b);
}
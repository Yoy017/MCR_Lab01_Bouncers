package shape.circle;

import graphic.Renderer;
import graphic.RendererBorder;

import java.awt.*;

public class CircleBorder extends Circle {
    public CircleBorder() {
        super(Color.GREEN);
    }

    @Override
    protected Renderer getRenderer() {
        return RendererBorder.getInstance();
    }
}

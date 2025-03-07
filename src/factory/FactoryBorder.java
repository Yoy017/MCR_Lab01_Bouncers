package factory;

import graphic.Renderer;
import shape.Bouncable;
import shape.circle.CircleBorder;
import shape.square.SquareBorder;

public class FactoryBorder implements FactoryAbstractShape {
    @Override
    public Bouncable createCircle(Renderer renderer) {
        return new CircleBorder(renderer);
    }

    @Override
    public Bouncable createSquare(Renderer renderer) {
        return new SquareBorder(renderer);
    }
}

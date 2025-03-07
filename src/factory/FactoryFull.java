package factory;

import graphic.Renderer;
import shape.Bouncable;
import shape.circle.CircleFull;
import shape.square.SquareFull;

public class FactoryFull implements FactoryAbstractShape {
    @Override
    public Bouncable createCircle(Renderer renderer) {
        return new CircleFull(renderer);
    }

    @Override
    public Bouncable createSquare(Renderer renderer) {
        return new SquareFull(renderer);
    }
}

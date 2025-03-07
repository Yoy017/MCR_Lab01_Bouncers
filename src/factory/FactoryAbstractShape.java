package factory;

import graphic.Renderer;
import shape.Bouncable;

public interface FactoryAbstractShape {
    Bouncable createCircle(Renderer renderer);
    Bouncable createSquare(Renderer renderer);
}

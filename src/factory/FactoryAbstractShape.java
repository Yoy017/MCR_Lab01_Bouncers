package factory;

import graphic.Renderer;
import shape.Bouncable;

public interface FactoryAbstractShape {
    Bouncable createSquare();
    Bouncable createCircle();
}

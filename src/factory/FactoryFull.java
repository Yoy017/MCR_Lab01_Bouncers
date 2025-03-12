package factory;

import shape.Bouncable;
import shape.circle.CircleFull;
import shape.circle.SquareFull;

public class FactoryFull implements FactoryAbstractShape {
    private static FactoryFull instance;

    private FactoryFull() {
    }

    public static FactoryFull getInstance() {
        if (instance == null) {
            instance = new FactoryFull();
        }
        return instance;
    }

    @Override
    public Bouncable createCircle() {
        return new CircleFull();
    }

    @Override
    public Bouncable createSquare() {
        return new SquareFull();
    }
}

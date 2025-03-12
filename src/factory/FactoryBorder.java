package factory;

import shape.Bouncable;
import shape.circle.CircleBorder;
import shape.circle.SquareBorder;

public class FactoryBorder implements FactoryAbstractShape {
    private static FactoryBorder instance;

    private FactoryBorder() {
    }

    public static FactoryBorder getInstance() {
        if (instance == null) {
            instance = new FactoryBorder();
        }
        return instance;
    }

    @Override
    public Bouncable createCircle() {
        return new CircleBorder();
    }

    @Override
    public Bouncable createSquare() {
        return new SquareBorder();
    }
}

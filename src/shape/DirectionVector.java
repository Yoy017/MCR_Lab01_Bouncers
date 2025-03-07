package shape;

import java.util.Random;

public class DirectionVector {
    public double dx, dy;
    private static final Random random = new Random();

    public DirectionVector(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public static DirectionVector randomDirection(double minSpeed, double maxSpeed) {
        double speedX = (random.nextDouble() * (maxSpeed - minSpeed)) + minSpeed;
        double speedY = (random.nextDouble() * (maxSpeed - minSpeed)) + minSpeed;

        if (random.nextBoolean()) speedX = -speedX;
        if (random.nextBoolean()) speedY = -speedY;

        return new DirectionVector(speedX, speedY);
    }

    public void invertX() {dx = -dx;}

    public void invertY() {dy = -dy;}
}

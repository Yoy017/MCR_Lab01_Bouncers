package shape;

import java.util.Random;

public class DirectionVector {
    private double dx, dy;
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

//    public void invertX() { dx = -dx; }
//
//    public void invertY() { dy = -dy; }

    public double getX() {return dx;}

    public double getY() {return dy;}

    public void setX(double dx) { this.dx = dx; }

    public void setY(double dy) { this.dy = dy; }
}

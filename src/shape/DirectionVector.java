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
        /*// random speed between minSpeed and maxSpeed
        double speed = minSpeed + (random.nextDouble() * (maxSpeed - minSpeed));
        // random angle between 0 and 2PI
        //double angle = random.nextDouble() * 2 * Math.PI;
        double angle;
        do {
            angle = random.nextDouble() * 2 * Math.PI;
        } while(Math.abs(Math.cos(angle)) < 0.5 || Math.abs(Math.sin(angle)) < 0.5);

        return new shape.DirectionVector(speed * Math.cos(angle), speed * Math.sin(angle));*/
        double speedX = (random.nextDouble() * (maxSpeed - minSpeed)) + minSpeed;
        double speedY = (random.nextDouble() * (maxSpeed - minSpeed)) + minSpeed;

        if (random.nextBoolean()) speedX = -speedX;
        if (random.nextBoolean()) speedY = -speedY;

        return new DirectionVector(speedX, speedY);
    }

    public void invertX() {dx = -dx;}

    public void invertY() {dy = -dy;}
}

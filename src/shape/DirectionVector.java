/**
 * DirectionVector.java
 * @authors Bleuer Rémy, Changanaqui Yoann
 * 14.03.25
 * MCR-A
 */

package shape;

import java.util.Random;

/**
 * @brief DirectionVector class to create a direction vector.
 */
public class DirectionVector {
    private double dx, dy;
    private static final Random random = new Random();

    /**
     * Create a direction vector.
     * @param dx the x component
     * @param dy the y component
     */
    public DirectionVector(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * Create a random direction vector.
     * @param minSpeed the minimum speed
     * @param maxSpeed the maximum speed
     * @return a random direction vector
     */
    public static DirectionVector randomDirection(double minSpeed, double maxSpeed) {
        // randomize the speed
        double speedX = (random.nextDouble() * (maxSpeed - minSpeed)) + minSpeed;
        double speedY = (random.nextDouble() * (maxSpeed - minSpeed)) + minSpeed;

        // randomize the direction
        if (random.nextBoolean()) speedX = -speedX;
        if (random.nextBoolean()) speedY = -speedY;

        return new DirectionVector(speedX, speedY);
    }

    /**
     * @return the x component of the direction vector
     */
    public double getX() {return dx;}

    /**
     * @return the y component of the direction vector
     */
    public double getY() {return dy;}

    /**
     * Set the x component of the direction vector.
     * @param dx the x component
     */
    public void setX(double dx) { this.dx = dx; }

    /**
     * Set the y component of the direction vector.
     * @param dy the y component
     */
    public void setY(double dy) { this.dy = dy; }
}

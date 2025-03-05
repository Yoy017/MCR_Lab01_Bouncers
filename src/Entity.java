import javax.swing.*;
import java.awt.*;

/**
 * @brief Classe abstraite représentant une entité graphique en mouvement.
 *
 * Cette classe définit le comportement de base d'une entité qui peut
 * se déplacer dans une fenêtre et rebondir sur les bords.
 */
abstract public class Entity extends JComponent {
    protected Color color;
    protected int size, x, y;
    protected DirectionVector movement;

    protected Entity(Color color) {
        this.color = color;
        this.size = (int) (Math.random() * 5) + 15; // random size between 5 and 20 px
        // initial position
        this.x = 0;
        this.y = 0;
        // vector of movement
        this.movement = DirectionVector.randomDirection(1, 5);
    }

    /**
     * @brief Déplace l'entité et gère les rebonds sur les bords de la fenêtre.
     *
     * Cette méthode met à jour la position de l'entité en fonction de sa vitesse
     * et inverse les composantes de vitesse lorsque l'entité atteint un bord.
     */
    public void move() {
        GraphicalWindow panel = GraphicalWindow.getInstance();
        int panelWidth = panel.getWidth();
        int panelHeight = panel.getHeight();

        y += (int) movement.dy;
        x += (int) movement.dx;
        if(y <= 0 || y + size >= panelHeight) movement.invertY();
        if(x <= 0 || x + size >= panelWidth) movement.invertX();
    }

    /**
     * @brief Dessine l'entité sur le contexte graphique fourni.
     * @param g Contexte graphique sur lequel dessiner
     */
    public abstract void draw(Graphics g);
}
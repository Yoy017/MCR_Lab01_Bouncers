package shape;

import graphic.GraphicalWindow;
import graphic.Renderer;

import javax.swing.*;
import java.awt.*;

/**
 * @brief Classe abstraite représentant une entité graphique en mouvement.
 *
 * Cette classe définit le comportement de base d'une entité qui peut
 * se déplacer dans une fenêtre et rebondir sur les bords.
 */
abstract public class AbstractShape implements Bouncable {
    protected Color color;
    protected int size;
    protected int x;
    protected int y;
    protected DirectionVector movement;
    protected Renderer renderer;

    protected AbstractShape(Color color, Renderer renderer) {
        this.color = color;
        this.renderer = renderer;
        this.size = (int) (Math.random() * 5) + 15; // random size between 5 and 20 px
        // initial position
        this.x = (int) (Math.random() * GraphicalWindow.getInstance().getWidth());;
        this.y = (int) (Math.random() * GraphicalWindow.getInstance().getHeight());;
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
     */
    @Override
    public void draw() {
        renderer.display(GraphicalWindow.getInstance().getGraphics(), this);
    };

    @Override
    public Color getColor() {
        return color;
    }
}
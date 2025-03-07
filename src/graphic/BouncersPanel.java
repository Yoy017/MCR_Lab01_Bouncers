package graphic;

import shape.Entity;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;

/**
 * @brief Panneau pour dessiner les entités en mouvement.
 *
 * Cette classe étend JPanel et gère le dessin des entités dans la fenêtre graphique.
 * Elle reçoit une référence à la liste des entités et les dessine lors de l'appel à paintComponent.
 */
public class BouncersPanel extends JPanel {
    private final Collection<Entity> bouncers;

    /**
     * @brief Constructeur initialisant le panneau avec la liste des entités.
     * @param bouncers Liste des entités à dessiner
     */
    public BouncersPanel(Collection<Entity> bouncers) {
        this.bouncers = bouncers;
        setBackground(Color.WHITE);
    }

    /**
     * @brief Méthode de dessin du panneau.
     *
     * Cette méthode est appelée automatiquement lors des rafraîchissements
     * et dessine toutes les entités sur le contexte graphique.
     *
     * @param g Contexte graphique sur lequel dessiner
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (Entity entity : bouncers) {
            entity.draw(g2);
        }
    }
}
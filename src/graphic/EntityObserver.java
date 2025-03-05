package graphic;

/**
 * @brief Interface définissant un observateur d'entités.
 *
 * Cette interface implémente le pattern Observer et permet à des objets
 * d'être notifiés lorsque l'état des entités change et qu'un rafraîchissement
 * est nécessaire.
 */
public interface EntityObserver {
    void update();
}
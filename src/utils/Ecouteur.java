package utils;

/**
 * Cette interface définit la méthode update pour les écouteurs.
 * Les classes qui veulent écouter des événements doivent implémenter cette interface.
 * 
 * @author Boluwatife ADEKOYA
 */
public interface Ecouteur {
    
    /**
     * Met à jour l'écouteur en réaction à un événement.
     * 
     * @param source la source de l'événement
     */
    public void update(Ecoutable source);
}
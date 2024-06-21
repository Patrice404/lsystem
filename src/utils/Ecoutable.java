package utils;

/**
 * Cette interface définit les méthodes nécessaires pour gérer les écouteurs.
 * Les classes qui veulent être écoutées doivent implémenter cette interface.
 * 
 * @author Boluwatife ADEKOYA
 */
public interface Ecoutable {
    
    /**
     * Ajoute un écouteur.
     * 
     * @param e l'écouteur à ajouter
     */
    public void addEcouteur(Ecouteur e);

    /**
     * Supprime un écouteur.
     * 
     * @param e l'écouteur à supprimer
     */
    public void removeEcouteur(Ecouteur e);

    /**
     * Notifie tous les écouteurs en appelant leur méthode update.
     */
    public void notifyAllEcouteur();
}
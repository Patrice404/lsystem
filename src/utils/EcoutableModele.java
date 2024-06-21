package utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe abstraite représente un modèle écoutable.
 * Elle implémente les méthodes nécessaires pour gérer les écouteurs et notifier les modifications.
 * Elle étend la classe abstraite Ecoutable.
 * 
 * @author Boluwatife ADEKOYA
 */
public abstract class EcoutableModele implements Ecoutable {
    
    protected List<Ecouteur> listEcouteur;

    /**
     * Constructeur de la classe EcoutableModele.
     * Initialise la liste des écouteurs.
     */
    public EcoutableModele() {
        listEcouteur = new ArrayList<Ecouteur>();
    }

    /**
     * Ajoute un écouteur à la liste des écouteurs.
     * 
     * @param e l'écouteur à ajouter
     */
    @Override
    public void addEcouteur(Ecouteur e) {
        listEcouteur.add(e);
    }

    /**
     * Supprime un écouteur de la liste des écouteurs.
     * 
     * @param e l'écouteur à supprimer
     */
    @Override
    public void removeEcouteur(Ecouteur e) {
        listEcouteur.remove(e);
    }

    /**
     * Notifie tous les écouteurs en appelant leur méthode update.
     */
    @Override
    public void notifyAllEcouteur() {
        for (Ecouteur ecouteur : listEcouteur) {
            ecouteur.update(this);
        }
    }
}

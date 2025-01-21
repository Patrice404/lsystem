package utils;

import java.util.ArrayList;
import java.util.List;

public abstract class EcoutableModele implements Ecoutable{
    protected List<Ecouteur> listEcouteur;
    public EcoutableModele(){
        listEcouteur = new ArrayList<Ecouteur>();
    }

    @Override
    public void addObserveur(Ecouteur e){
        listEcouteur.add(e);
    }

    @Override
    public void removeObserveur(Ecouteur e){
        listEcouteur.remove(e);
    }

    @Override
    public void notifyAllObserveur(){
        for (Ecouteur ecouteur : listEcouteur) {
            ecouteur.update(this);
        }
    }

}

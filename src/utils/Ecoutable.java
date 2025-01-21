package utils;

public interface Ecoutable {
    public void addObserveur(Ecouteur e);
    public void removeObserveur(Ecouteur e);
    public void notifyAllObserveur();
}

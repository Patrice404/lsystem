package utils;
/**
 * Cette classe représente un point dans un système de coordonnées.
 * Elle est utilisée pour la représentation graphique de l'arbre.
 * 
 * @author Boluwatife ADEKOYA
 */
public class Position {
    private int x;
    private int y;
    private float angle;
    
    /**
     * Constructeur de la classe Position.
     * 
     * @param x l'abscisse du point
     * @param y l'ordonnée du point
     * @param angle l'angle d'orientation du point en degrés
     */
    public Position(int x, int y, float angle) {
        this.x = x;
        this.y = y;
        this.angle = angle;
    }
    
    /**
     * Obtient l'abscisse du point.
     * 
     * @return l'abscisse du point
     */
    public int getX() {
        return x;
    }

    /**
     * Obtient l'ordonnée du point.
     * 
     * @return l'ordonnée du point
     */
    public int getY() {
        return y;
    }
    
    /**
     * Modifie l'abscisse du point.
     * 
     * @param x la nouvelle valeur de l'abscisse
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Modifie l'ordonnée du point.
     * 
     * @param y la nouvelle valeur de l'ordonnée
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Obtient l'angle d'orientation du point.
     * 
     * @return l'angle d'orientation du point
     */
    public float getAngle() {
        return angle;
    }

    /**
     * Modifie l'angle d'orientation du point.
     * 
     * @param angle le nouvel angle d'orientation
     */
    public void setAngle(float angle) {
        this.angle = angle;
    }
    
    /**
     * Renvoie une représentation textuelle de la position.
     * 
     * @return la représentation textuelle de la position
     */
    @Override
    public String toString() {
        return "(" + x + "," + y + ") - " + angle;
    }
}
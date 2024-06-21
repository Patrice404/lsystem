package view.rendu;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;

import utils.Ecoutable;
import utils.Ecouteur;
import utils.Position;
import view.RenderedZone;
/**
 * Cette classe représente le rendu 2D d'un arbre.
 * Il est chargé de dessiner l'arbre en fonction de sa configuration.
 * Implémente le pattern Observer pour notifier la classe Fenêtre à chaque modification.
 * 
 * @author Patrice Z. D. COTCHO
 */
public class Rendu2D extends JComponent implements Ecoutable {
    
    public static final int LARGEUR = RenderedZone.LARGEUR/2;
    public static final int HAUTEUR = RenderedZone.HAUTEUR-150;
    
    private List<Ecouteur> listObserveurs;
    private String chaine;
    private float angle;
    public Graphics2D g2D;

    /**
     * Constructeur de la classe Rendu2D.
     * 
     * @param chaine La chaîne de configuration de l'arbre.
     * @param angle L'angle de rotation pour les instructions de rotation.
     */
    public Rendu2D(String chaine, float angle) {
        super();
        this.listObserveurs = new ArrayList<>();
        this.chaine = chaine;
        this.angle = angle;
    }

    /**
     * Définit la chaîne de configuration de l'arbre.
     * 
     * @param chaine La chaîne de configuration de l'arbre.
     */
    public void setChaine(String chaine) {
        this.chaine = chaine;
    }

    /**
     * Définit l'angle de rotation pour les instructions de rotation.
     * 
     * @param angle L'angle de rotation.
     */
    public void setAngle(float angle) {
        this.angle = angle;
    }

    /**
     * Redéfinition de la méthode paintComponent pour dessiner l'arbre.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.g2D = (Graphics2D) g;
        this.g2D.setColor(Color.BLACK);

        float angleLocal = 0;
        int initX = Rendu2D.LARGEUR;
        int initY = Rendu2D.HAUTEUR;
        int endX = 0;
        int endY = 0;
        ArrayList<Position> positions = new ArrayList<>();

        String[] sousChaine = this.chaine.split("");
        for (String symbole : sousChaine) {
            if (symbole.equals("+")) {
                angleLocal += this.angle;
            } else if (symbole.equals("-")) {
                angleLocal -= this.angle;
            } else if (symbole.equals("[")) {
                positions.add(new Position(endX, endY, angleLocal));
            } else if (symbole.equals("]")) {
                Position p = positions.remove(positions.size() - 1);
                endX = p.getX();
                endY = p.getY();
                angleLocal = p.getAngle();
            } else if (Character.isLetter(symbole.charAt(0))) {
                if (endX != 0 && endY != 0) {
                    initX = endX;
                    initY = endY;
                }
                endX = (int) (initX - 10 * Math.sin(Math.toRadians(angleLocal)));
                endY = (int) (initY - 10 * Math.cos(Math.toRadians(angleLocal)));
                this.g2D.drawLine(initX, initY, endX, endY);
            }
        }
    }

    /**
     * Définit une nouvelle configuration pour le rendu 2D de l'arbre.
     * 
     * @param chaine La nouvelle chaîne de configuration de l'arbre.
     * @param angle Le nouvel angle de rotation pour les instructions de rotation.
     */
    public void setRendu2D(String chaine, float angle){
        this.setChaine(chaine);
        this.setAngle(angle);
        this.notifyAllEcouteur();
    }

    @Override
    public void addEcouteur(Ecouteur e) {
        this.listObserveurs.add(e);
    }

    @Override
    public void removeEcouteur(Ecouteur e) {
        this.listObserveurs.remove(e);
    }

    @Override
    public void notifyAllEcouteur() {
        for (Ecouteur observeur : this.listObserveurs) {
            observeur.update(this);
        }
    }

}



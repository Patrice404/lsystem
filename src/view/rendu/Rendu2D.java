package view.rendu;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;

import utils.Ecoutable;
import utils.Ecouteur;
import utils.Position;
import view.RenderedZone;
/*
 * Cette class représente le rendu 2D
 * La class chargé de déssiner l'arbre issue de la configuration
 * Il implémente le pattern  Observer. Le but est de notifier la class Fênetre a chaque fois qu'elle est modifiée
 * @author Patrice Z. D. COTCHO
 */
public class Rendu2D extends JComponent implements Ecoutable {
    
    public static final int LARGEUR = RenderedZone.LARGEUR/2;
    public static final int HAUTEUR = RenderedZone.HAUTEUR-150;
    
    private List<Ecouteur> listObserveurs;
    private String chaine;
    private float angle;
    public Graphics2D g2D;

    public Rendu2D(String chaine, float angle) {
        super();
        this.listObserveurs = new ArrayList<Ecouteur>();
        this.chaine = chaine;
        this.angle = angle;
    }

    public void setChaine(String chaine) {
        this.chaine = chaine;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.g2D = (Graphics2D) g;
        this.g2D.setColor(Color.BLACK);
        //this.g2D.scale(1.5, 0.5);
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

    public void setRendu2D(String chaine, float angle){
        this.setChaine(chaine);
        this.setAngle(angle);
        this.notifyAllObserveur();
    }

    @Override
    public void addObserveur(Ecouteur e) {
        this.listObserveurs.add(e);
    }

    @Override
    public void removeObserveur(Ecouteur e) {
        this.listObserveurs.remove(e);
    }

    @Override
    public void notifyAllObserveur() {
        for (Ecouteur observeur : this.listObserveurs) {
            observeur.update(this);
        }
    }

}

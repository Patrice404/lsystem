/**
 * Cette classe représente la barre d'outils de l'interface utilisateur.
 * Elle contient un ensemble de boutons proposant des exemples d'arbres et leurs configurations.
 * 
 * @author Patrice D. Z. COTCHO
 */
package view;

import javax.swing.*;
import java.awt.*;

public class ToolBar extends JToolBar {

    private final Dimension BTN_DIMENSION = new Dimension(120, 30);

    private JButton arbre1Button;
    private JButton arbre2Button;
    private JButton arbre3Button;
    private JButton arbre4Button;
    private JButton arbre5Button;
    private JButton arbre6Button;
    private JButton arbre7Button;

    /**
     * Constructeur de la classe ToolBar.
     * Initialise la configuration par défaut de la barre d'outils.
     */
    public ToolBar() {
        super();
        this.makeToolBar();
    }

    /**
     * Méthode privée de configuration de la barre d'outils.
     * Initialise les boutons et les ajoute à la barre d'outils.
     */
    private void makeToolBar() {
        this.arbre1Button = new JButton("ARBRE_1");
        this.arbre2Button = new JButton("ARBRE_2");
        this.arbre3Button = new JButton("ARBRE_3");
        this.arbre4Button = new JButton("ARBRE_4");
        this.arbre5Button = new JButton("ARBRE_5");
        this.arbre6Button = new JButton("ARBRE_6");
        this.arbre7Button = new JButton("ARBRE_7");

        this.arbre1Button.setPreferredSize(BTN_DIMENSION);
        this.arbre2Button.setPreferredSize(BTN_DIMENSION);
        this.arbre3Button.setPreferredSize(BTN_DIMENSION);
        this.arbre4Button.setPreferredSize(BTN_DIMENSION);
        this.arbre5Button.setPreferredSize(BTN_DIMENSION);
        this.arbre6Button.setPreferredSize(BTN_DIMENSION);
        this.arbre7Button.setPreferredSize(BTN_DIMENSION);

        JLabel titreBtn = new JLabel("Des exemples d'arbres ->");

        this.add(titreBtn);
        this.add(this.arbre1Button);
        this.add(this.arbre2Button);
        this.add(this.arbre3Button);
        this.add(this.arbre4Button);
        this.add(this.arbre5Button);
        this.add(this.arbre6Button);
        this.add(this.arbre7Button);
        this.setVisible(true);
    }

    /**
     * Récupère le bouton "ARBRE_1".
     * 
     * @return Le bouton "ARBRE_1".
     */
    public JButton getArbre1Button(){
        return this.arbre1Button;
    }

    /**
     * Récupère le bouton "ARBRE_2".
     * 
     * @return Le bouton "ARBRE_2".
     */
    public JButton getArbre2Button(){
        return this.arbre2Button;
    }

    /**
     * Récupère le bouton "ARBRE_3".
     * 
     * @return Le bouton "ARBRE_3".
     */
    public JButton getArbre3Button(){
        return this.arbre3Button;
    }

    /**
     * Récupère le bouton "ARBRE_4".
     * 
     * @return Le bouton "ARBRE_4".
     */
    public JButton getArbre4Button(){
        return this.arbre4Button;
    }

    /**
     * Récupère le bouton "ARBRE_5".
     * 
     * @return Le bouton "ARBRE_5".
     */
    public JButton getArbre5Button(){
        return this.arbre5Button;
    }

    /**
     * Récupère le bouton "ARBRE_6".
     * 
     * @return Le bouton "ARBRE_6".
     */
    public JButton getArbre6Button(){
        return this.arbre6Button;
    }

    /**
     * Récupère le bouton "ARBRE_7".
     * 
     * @return Le bouton "ARBRE_7".
     */
    public JButton getArbre7Button(){
        return this.arbre7Button;
    }

}
/**
 * Cette classe représente la zone de rendu sur l'interface graphique.
 * Elle permet d'afficher des éléments en 2D ou 3D avec des fonctionnalités de zoom et dézoom.
 * 
 * @author Patrice D. Z. COTCHO
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.border.*;

public class RenderedZone extends JPanel{

    /**
     * Largeur par défaut de la zone de rendu.
     */
    public static final int LARGEUR = ((4 * Interface.LARGEUR) / 5) - 100;

    /**
     * Hauteur par défaut de la zone de rendu.
     */
    public static final int HAUTEUR = Interface.HAUTEUR - 100;

    private JPanel renduPanel = new JPanel(new BorderLayout());
    private JRadioButton rendu2DBoutton, rendu3DBoutton;
    private JButton zoomBoutton, dezoomBoutton;
    
    /**
     * Constructeur de la classe RenderedZone.
     * Initialise la configuration de la zone de rendu.
     */
    public RenderedZone(){
        super();

        setConfiguration();
        this.renduPanel.setPreferredSize(new Dimension(RenderedZone.LARGEUR, RenderedZone.HAUTEUR));
        this.add(this.renduPanel, BorderLayout.CENTER);
        this.setVisible(true);
    }

    private void setConfiguration(){
        // Création des boutons de choix de rendus
        this.rendu2DBoutton = new JRadioButton("2D");
        this.rendu2DBoutton.setSelected(true);
        this.rendu3DBoutton = new JRadioButton("3D");
        ButtonGroup rendBtnGroup = new ButtonGroup();
        rendBtnGroup.add(this.rendu2DBoutton);
        rendBtnGroup.add(this.rendu3DBoutton);

        JPanel renduBtnPanel = new JPanel();
        renduBtnPanel.setPreferredSize(new Dimension(100, 40));
        renduBtnPanel.add(this.rendu2DBoutton);
        renduBtnPanel.add(this.rendu3DBoutton);

        this.zoomBoutton = new JButton("+");
        this.zoomBoutton.setBackground(Color.GRAY);
        this.dezoomBoutton = new JButton("-");
        this.dezoomBoutton.setBackground(Color.GRAY);
        JPanel zoomPanel = new JPanel();
        zoomPanel.setPreferredSize(new Dimension(100, 40));
        zoomPanel.add(this.zoomBoutton);
        zoomPanel.add(this.dezoomBoutton);

        this.setLayout(new BorderLayout());
        this.renduPanel.setBorder(new TitledBorder(new LineBorder(Color.BLUE, 5), "Zone de rendu "));

        this.add(renduBtnPanel, BorderLayout.NORTH);
        this.add(zoomPanel, BorderLayout.SOUTH);
    }

    /**
     * Récupère le panneau de rendu contenu dans un JScrollPane.
     * 
     * @return Le JScrollPane contenant le panneau de rendu.
     */
    JScrollPane getRenduPanel(){
        JScrollPane scrollPane = new JScrollPane(this.renduPanel);
        return scrollPane;
    }

    /**
     * Récupère le panneau de rendu.
     * 
     * @return Le panneau de rendu.
     */
    public JPanel getRendu(){
        return this.renduPanel;
    }

    /**
     * Récupère le bouton de zoom.
     * 
     * @return Le bouton de zoom.
     */
    public JButton getZoomButton(){
        return this.zoomBoutton;
    }

    /**
     * Récupère le bouton de dézoom.
     * 
     * @return Le bouton de dézoom.
     */
    public JButton getDezoomButton(){
        return this.dezoomBoutton;   
    }

    /**
     * Récupère le bouton de rendu 2D.
     * 
     * @return Le bouton de rendu 2D.
     */
    public JRadioButton getRendu2DBoutton(){
        return this.rendu2DBoutton;
    }

    /**
     * Récupère le bouton de rendu 3D.
     * 
     * @return Le bouton de rendu 3D.
     */
    public JRadioButton getRendu3DBoutton(){
        return this.rendu3DBoutton;
    }
}
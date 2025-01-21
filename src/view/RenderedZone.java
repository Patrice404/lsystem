package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.border.*;

/*
 * Cette class represente la zone de rendu sur l'interface 
 * @author Patrice D. Z. COTCHO
 */
public class RenderedZone extends JPanel{
    public static final int LARGEUR = ((4 * Interface.LARGEUR) / 5)-100;
    public static final int HAUTEUR = Interface.HAUTEUR-100;

    private JPanel renduPanel = new JPanel(new BorderLayout());
    private JRadioButton rendu2DBoutton, rendu3DBoutton;
    private JButton zoomBoutton, dezoomBoutton;
    
    public RenderedZone(){
        super();

        setConfiguration();
        this.renduPanel.setPreferredSize(new Dimension(RenderedZone.LARGEUR,RenderedZone.HAUTEUR));
        this.add(this.renduPanel,BorderLayout.CENTER);
        this.setVisible(true);
    }

    private void setConfiguration(){
        //Création des boutons de choix de rendus
        this.rendu2DBoutton = new JRadioButton("2D");
        this.rendu2DBoutton.setSelected(true);
        this.rendu3DBoutton = new JRadioButton("3D");
        ButtonGroup rendBtnGroup = new ButtonGroup();
        rendBtnGroup.add(this.rendu2DBoutton);
        rendBtnGroup.add(this.rendu3DBoutton);

        JPanel renduBtnPanel = new JPanel();
        renduBtnPanel.setPreferredSize(new Dimension(100,40));
        renduBtnPanel.add(this.rendu2DBoutton);
        renduBtnPanel.add(this.rendu3DBoutton);

        this.zoomBoutton = new JButton("+");
        this.zoomBoutton.setBackground(Color.GRAY);
        this.dezoomBoutton = new JButton("-");
        this.dezoomBoutton.setBackground(Color.GRAY);
        JPanel zoomPanel = new JPanel();
        zoomPanel.setPreferredSize(new Dimension(100,40));
        zoomPanel.add(this.zoomBoutton);
        zoomPanel.add(this.dezoomBoutton);

        //this.setBorder(new TitledBorder(new LineBorder(Color.GRAY, 4),"Class ZoneRendu"));
        this.setLayout(new BorderLayout());
        this.renduPanel.setBorder(new TitledBorder(new LineBorder(Color.BLUE, 5),"Zone de rendu "));

        
        this.add(renduBtnPanel,BorderLayout.NORTH);
        this.add(zoomPanel,BorderLayout.SOUTH);
    }

    JScrollPane getRenduPanel(){
        JScrollPane scrollPane = new JScrollPane(this.renduPanel);
        return scrollPane;
    }

    public JPanel getRendu(){
        return this.renduPanel;
    }

    public JButton getZoomButton(){
        return this.zoomBoutton;
    }

    public JButton getDezoomButton(){
        return this.dezoomBoutton;   
    }

    public JRadioButton getRendu2DBoutton(){
        return this.rendu2DBoutton;
    }

    public JRadioButton getRendu3DBoutton(){
        return this.rendu3DBoutton;
    }
}

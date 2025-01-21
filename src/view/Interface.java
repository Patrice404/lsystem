package view;

import java.awt.*;
import javax.swing.*;

import utils.Ecoutable;
import utils.Ecouteur;
import view.rendu.*;

/**
 * Cette classe représente l'interface graphique de l'application.
 * Il s'agit de la fenêtre qui s'ouvrira à l'utilsateur lors du lancement de l'application
 * Elle fait appel à toutes les autres class crées dans ce package pour sa construction.
 * Elle implémente le pattern Observeur.
 * Elle garde un oeuil sur le rendu 2D et se met à jours à chaque modification de se dernier
 * @author Patrice D. Z. COTCHO
 */
public class Interface extends JFrame implements Ecouteur {

    public static Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int LARGEUR = tailleEcran.width;
    public static final int HAUTEUR = tailleEcran.height ;
    // private int nbRegle;

    private Menu menu;

    private ToolBar toolbar;
    private Configuration configuration;
    private RenderedZone zoneRendu;
    private JPanel centerPanel;
    private Rendu2D rendu2D;
    private Rendu3D rendu3D;

    // private JPanel contentPane;

    /*
     * Constructeur de la classe
     * 
     * @return et affiche l'interface graphique de l'utilisateur
     */   
    public Interface() {
        // La fênetre observe le rendu2D
        this.rendu2D = new Rendu2D("", 0f);
        this.rendu2D.addObserveur(this);
        //this.rendu3D = new Rendu3D("", 0f);
        //this.rendu3D.addObserveur(this);

        this.setTitle("Interface utilisateur L-Systèm");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        // this.setResizable(false);
        this.setPreferredSize(new Dimension(LARGEUR, HAUTEUR));

        this.initComponent();

        this.configureFenetre();
    }

    private void initComponent() {
        this.menu = new Menu();
        this.setJMenuBar(this.menu);

        this.toolbar = new ToolBar();
        this.configuration = new Configuration((LARGEUR / 5) + 100, HAUTEUR);
        this.zoneRendu = new RenderedZone();

        this.centerPanel = new JPanel();

        this.getContentPane().setLayout(new BorderLayout(10, 10));
    }

    /*
     * Méthode qui permet de configurer les composants de l'interface
     * Il a été créee dans le but de ne pas surcharger le constructeur
     */
    public void configureFenetre() {

        this.centerPanel.setLayout(new BorderLayout(30, 30));
        this.centerPanel.add(this.configuration, BorderLayout.EAST);
        this.centerPanel.add(this.zoneRendu, BorderLayout.CENTER);

        this.getContentPane().add(centerPanel, BorderLayout.CENTER);
        this.getContentPane().add(this.toolbar, BorderLayout.NORTH);
        // this.setLocationRelativeTo(null); // centrage écran
        this.pack();
        this.setVisible(true);
    }

    // A chaque modification des rendus cette méthode est appelée
    // Il s'agit de la mise à jour de la vue
    @Override
    public void update(Ecoutable source) {
        this.getZoneRendu().getRendu().removeAll();
        if (source.equals(this.rendu2D)) {
            // Mise à jours de la vue
            this.getZoneRendu().getRendu().add(this.rendu2D, BorderLayout.CENTER);
        }
        this.getZoneRendu().getRendu().setVisible(false);
        this.getZoneRendu().getRendu().setVisible(true);
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public ToolBar getToolbar() {
        return toolbar;
    }

    public void setToolbar(ToolBar toolbar) {
        this.toolbar = toolbar;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public Rendu2D getRendu2D() {
        return rendu2D;
    }

    public void setRendu2D(Rendu2D rendu2d) {
        this.rendu2D = rendu2d;
    }

    public RenderedZone getZoneRendu() {
        return zoneRendu;
    }

    public void setZoneRendu(RenderedZone zoneRendu) {
        this.zoneRendu = zoneRendu;
    }

    public JPanel getCenterPanel() {
        return centerPanel;
    }

    public Rendu3D getRendu3D() {
        return rendu3D;
    }

    public void setRendu3D(Rendu3D rendu3d) {
        this.rendu3D = rendu3d;
    }

}

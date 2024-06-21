package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant le panneau de configuration de l'application.
 * Ce panneau permet à l'utilisateur de spécifier les paramètres de génération et de définir les règles.
 */
public class Configuration extends JPanel {
    public static final Dimension FIELD_DIMENSION = new Dimension(300, 40);
    public static final Dimension PANEL_DIMENSION = new Dimension(50, 100);
    public static final FlowLayout PANEL_LAYOUT = new FlowLayout(FlowLayout.CENTER, 90, 20);
    public static final Font FIELD_FONT = new Font("", Font.BOLD, 15);

    private JTextField axiom, angle, iteration, regle1;
    private JPanel configPanel, buttonsPanel;
    private JButton genererButton, clearButton, newrulesButton;
    private List<JTextField> listeRegleTextField;
    private List<JLabel> listeLabels = new ArrayList<JLabel>();

    public Configuration(int LARGEUR, int HAUTEUR) {
        super();
        this.setPreferredSize(new Dimension(LARGEUR, HAUTEUR));
        this.setLayout(new BorderLayout(10, 20));

        this.initComponent();
        this.makeConfigPanel();
        this.makeButtonsPanel();
        JPanel titrePanel = new JPanel();
        titrePanel.setBorder(new EmptyBorder(10, 10, 20, 10));
        JLabel titre = new JLabel("Configuration");
        titre.setFont(new Font("", Font.BOLD, 25));
        titrePanel.add(titre);
        
        this.add(titrePanel, BorderLayout.NORTH);
        this.add(this.getConfigPanelScroll(), BorderLayout.CENTER);
        this.add(this.buttonsPanel, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    /**
     * Retourne un JScrollPane contenant le panneau de configuration.
     * 
     * @return un JScrollPane contenant le panneau de configuration.
     */
    JScrollPane getConfigPanelScroll() {
        JScrollPane scrollPane = new JScrollPane(this.configPanel);
        return scrollPane;
    }

    /**
     * Méthode d'initialisation des composants
     */
    private void initComponent() {
        this.axiom = new JTextField();
        this.angle = new JTextField();
        this.iteration = new JTextField();
        this.regle1 = new JTextField();
        this.listeRegleTextField = new ArrayList<JTextField>();
        this.listeLabels = new ArrayList<JLabel>();

        listeRegleTextField.add(this.regle1);

        this.configPanel = new JPanel();
        this.buttonsPanel = new JPanel();

        this.genererButton = new JButton("Generate");
        this.clearButton = new JButton("Clear");
        this.newrulesButton = new JButton("New Rule");
    }

    /**
     * Méthode qui permet de peupler le panel de la configuration
     */
    private void makeConfigPanel() {
        this.configPanel.setLayout(new BoxLayout(this.configPanel, BoxLayout.Y_AXIS));
        // this.configPanel.setPreferredSize(new Dimension(300,700));

        JPanel axiomPanel = new JPanel();
        setField("Axiom", axiomPanel, this.axiom);

        JPanel itterationPanel = new JPanel();
        setField("Itération", itterationPanel, this.iteration);

        JPanel anglePanel = new JPanel();
        setField("Angle", anglePanel, this.angle);

        JPanel regle1Panel = new JPanel();
        setField("Règle 1", regle1Panel, this.regle1);

        // this.configPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK,
        // 5),""));
        this.configPanel.add(axiomPanel);
        this.configPanel.add(itterationPanel);
        this.configPanel.add(anglePanel);
        this.configPanel.add(regle1Panel);
    }
    /**
     * Définit un champ de texte avec un label dans un panel spécifié.
     * 
     * @param titre le titre du champ de texte.
     * @param panel le panel où placer le champ de texte et le label.
     * @param field le champ de texte.
     */
    public void setField(String titre, JPanel panel, JTextField field) {
        panel.setPreferredSize(PANEL_DIMENSION);
        panel.setLayout(PANEL_LAYOUT);
        JLabel textLabel = new JLabel(titre);
        textLabel.setFont(FIELD_FONT);
        field.setPreferredSize(FIELD_DIMENSION);
        field.setFont(FIELD_FONT);
        panel.add(textLabel);
        panel.add(field);
    }

    /**
     * Méthode qui permet de peupler le panel des boutons en bas de la partie
     * configuration
     */

    private void makeButtonsPanel() {
        Dimension bntDimension = new Dimension(70, 40);
        Dimension bntDimension2 = new Dimension(90, 40);

        // this.buttonsPanel.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
        this.buttonsPanel.setPreferredSize(new Dimension(50, 70));
        this.buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        this.genererButton.setBackground(Color.GREEN);
        this.clearButton.setBackground(Color.RED);
        this.newrulesButton.setBackground(Color.GRAY);

        this.genererButton.setPreferredSize(bntDimension2);
        this.clearButton.setPreferredSize(bntDimension);
        this.newrulesButton.setPreferredSize(bntDimension2);

        this.buttonsPanel.add(this.genererButton);
        this.buttonsPanel.add(this.clearButton);
        this.buttonsPanel.add(this.newrulesButton);
    }

    // Getters for all component

    public JTextField getAxiom() {
        return this.axiom;
    }

    public JTextField getAngle() {
        return this.angle;
    }

    public JTextField getItteration() {
        return this.iteration;
    }

    public JTextField getRegle1() {
        return this.regle1;
    }

    public JButton getGenererButton() {
        return this.genererButton;
    }

    public JButton getClearButton() {
        return this.clearButton;
    }

    public JButton getNewRulesButton() {
        return this.newrulesButton;
    }

    public List<JTextField> getListeRegleTextField() {
        return this.listeRegleTextField;
    }

    public List<JLabel> getListeLabels() {
        return this.listeLabels;
    }

    public JPanel getConfigPanel() {
        return configPanel;
    }

    public JPanel getButtonsPanel() {
        return buttonsPanel;
    }

    public void setListeRegleTextFieldDefault(JTextField textField) {
        this.listeRegleTextField = new ArrayList<>();
        this.listeRegleTextField.add(textField);
    }

   
    /** 
    * On supprime tous les TextFiels supplémentaire de Règle sur la vue sauf le premier
    * Aussi on les supprime de la liste de textField
    */
    public void setDefaultConfiguration() {
        int nbTextField = this.listeRegleTextField.size();
        for (int i = nbTextField - 1; i >= 1; i--) {
            JTextField field = this.listeRegleTextField.get(i);
            JPanel panelParent = (JPanel) field.getParent();
            panelParent.removeAll();
            this.configPanel.remove(panelParent);
            this.listeRegleTextField.remove(field);
        }
        this.configPanel.revalidate();
        this.newrulesButton.setEnabled(true);

    }

}

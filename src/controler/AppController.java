package controler;

import java.awt.*;
import javax.swing.*;

import model.*;
import utils.GeneratorException;
import view.*;
import view.dialogue.*;
import view.rendu.*;

import java.util.List;
import java.awt.event.*;
import java.util.ArrayList;

/** Backend de l'application.
* Cette classe agit comme le contrôleur principal de l'application, gérant les interactions entre la vue et le modèle.
* Elle implémente l'interface ActionListener pour écouter les événements des composants de l'interface utilisateur.
* @author Patrice D. Z. COTCHO
*/
public class AppController implements ActionListener {

    private Interface windows;
    private Generator generateur;
    private List<Rule> listRegles;
    private String errorSMS;
     /**
     * Constructeur de la classe AppController.
     * @param windows L'interface graphique de l'application.
     * @param generateur Le générateur utilisé pour créer les rendus.
     * @param listRegles La liste des règles utilisées par le générateur.
     */

    public AppController(Interface windows, Generator generateur, List<Rule> listRegles) {
        this.windows = windows;
        this.generateur = generateur;
        this.listRegles = listRegles;
        this.setListerner();
    }

    /*
     * Méthode permettant d'écouter les différents composants de l'interface.
     */
    private void setListerner() {
        this.windows.getMenu().getQuitte().addActionListener(this);
        this.windows.getConfiguration().getClearButton().addActionListener(this::clearButtonListener);
        this.windows.getConfiguration().getNewRulesButton().addActionListener(this::newRegleButtonListener);
        this.windows.getConfiguration().getGenererButton().addActionListener(this::genererButtonListener);
        this.windows.getToolbar().getArbre1Button().addActionListener(this::toolBarListener);
        this.windows.getToolbar().getArbre2Button().addActionListener(this::toolBarListener);
        this.windows.getToolbar().getArbre3Button().addActionListener(this::toolBarListener);
        this.windows.getToolbar().getArbre4Button().addActionListener(this::toolBarListener);
        this.windows.getToolbar().getArbre5Button().addActionListener(this::toolBarListener);
        this.windows.getToolbar().getArbre6Button().addActionListener(this::toolBarListener);
        this.windows.getToolbar().getArbre7Button().addActionListener(this::toolBarListener);
        this.windows.getToolbar().getArbre8Button().addActionListener(this::toolBarListener);
        this.windows.getToolbar().getArbre9Button().addActionListener(this::toolBarListener);
        this.windows.getToolbar().getArbre10Button().addActionListener(this::toolBarListener);
        this.windows.getToolbar().getArbre11Button().addActionListener(this::toolBarListener);
        this.windows.getToolbar().getArbre12Button().addActionListener(this::toolBarListener);
        this.windows.getMenu().getApropos().addActionListener(this::helpItemListener);
        this.windows.getZoneRendu().getRendu2DBoutton().addActionListener(this::renduButtonListerner);
        this.windows.getZoneRendu().getRendu3DBoutton().addActionListener(this::renduButtonListerner);

    }

    

      /**
     * Méthode appelée lorsqu'un bouton de génération est cliqué.
     * Elle récupère les données de configuration de l'interface, génère le rendu correspondant
     * et met à jour l'affichage en conséquence.
     * @param event L'événement déclenché par le clic sur le bouton.
     */
    
    private void genererButtonListener(ActionEvent event) {
        if (goodConfiguration()) {
            // Récupération des données de configuration depuis la vue
            String axiom = this.windows.getConfiguration().getAxiom().getText().toUpperCase();
            List<JTextField> listeRegleTextField = this.windows.getConfiguration().getListeRegleTextField();

            int nbItt = Integer.parseInt(this.windows.getConfiguration().getItteration().getText());
            float angle = Float.parseFloat(this.windows.getConfiguration().getAngle().getText());
            this.listRegles.clear();

            for (JTextField regle : listeRegleTextField) {
                String texte = regle.getText();
                String champs[] = texte.split(":");
                this.listRegles.add(new Rule(champs[0], champs[1], Double.parseDouble(champs[2])));
            }
            // Modification du generateur et du rendu
            try {
                this.generateur.setGenerateur(axiom, listRegles);

                if (this.windows.getZoneRendu().getRendu2DBoutton().isSelected()) {
                    this.windows.getRendu2D().setRendu2D(this.generateur.generate(nbItt), angle);
                } else {
                    this.windows.setRendu3D(new Rendu3D(this.generateur.generate(nbItt), angle));

                    //Ajout des ecouteurs sur les deux boutons qui gèrent le zoom
                    this.windows.getZoneRendu().getZoomButton()
                            .addActionListener((Event) -> this.windows.getRendu3D().scale += 0.01);
                    this.windows.getZoneRendu().getDezoomButton()
                            .addActionListener((Event) -> this.windows.getRendu3D().scale -= 0.01);
                    //Mise à jours de la vue
                    this.windows.getZoneRendu().getRendu().removeAll();
                    this.windows.getZoneRendu().getRendu().add(this.windows.getRendu3D().glCanvas, BorderLayout.CENTER);
                    
                    this.windows.getZoneRendu().getRendu().repaint();
                    this.windows.getZoneRendu().getRendu().setVisible(false);
                   
                    this.windows.getZoneRendu().getRendu().setVisible(true);

                }
            } catch (GeneratorException e) {
                this.errorSMS = e.getMessage();
                new ErrorDialog(windows, this.errorSMS);
            }

        } else {
            // Afficher un message d'erreur a l'ecran
            new ErrorDialog(windows, errorSMS);
        }

    }

    /*
     * Méthide qui répond au clique des boutons contenus dans la toolbar
     */
    private void toolBarListener(ActionEvent event) {
        if (event.getSource().equals(this.windows.getToolbar().getArbre1Button())) {
            // Axiom => F Regle => F:F[+F]F[-F][F]:40 && F:F[-F]F[+F][F]:60 Angle => 20°
            // Itteration => 5
            List<String> regles = new ArrayList<>();
            regles.add("F:F[+F]F[-F][F]:40");
            regles.add("F:F[-F]F[+F][F]:60");
            this.setConfiguration("F", 20f, 5, regles);
            this.genererButtonListener(event);

        }
        if (event.getSource().equals(this.windows.getToolbar().getArbre2Button())) {
            // Axiom => X Règle => F:FF:100 and X:-F[+F][--X]+F-F[++X]-X:40 and
            // X:+F[-F][++X]-F+F[---X]+X:60 Angle => 10
            // Itteration => 4
            List<String> regles = new ArrayList<>();
            regles.add("F:FF:100");
            regles.add("X:-F[+F][--X]+F-F[++X]-X:40");
            regles.add("X:+F[-F][++X]-F+F[---X]+X:60");
            this.setConfiguration("X", 10f, 4, regles);
            this.genererButtonListener(event);

        }
        if (event.getSource().equals(this.windows.getToolbar().getArbre3Button())) {
            // Axiom => X Règle => X:F-[[X]+X]+F[+FX]-X && F:FF Angle => 22.5 Itteration => 5
            List<String> regles = new ArrayList<>();
            regles.add("X:F-[[X]+X]+F[+FX]-X:100");
            regles.add("F:FF:100");
           
            this.setConfiguration("X", 22.5f, 5, regles);
            this.genererButtonListener(event);

        }
        if (event.getSource().equals(this.windows.getToolbar().getArbre4Button())) {
            // Axiom => X Règle => F:FF:100 and X:F[+>>X]><[-<<X]FX:100 Angle => 25.7 Itteration
            // => 5
            List<String> regles = new ArrayList<>();
            regles.add("F:FF:100");
            regles.add("X:F[+>>X]><[-<<X]FX:100");
            this.setConfiguration("X", 25.7f, 5, regles);
            this.genererButtonListener(event);

        }
        if (event.getSource().equals(this.windows.getToolbar().getArbre5Button())) {
            // Axiom => X Règle => F:FF:100 and X:<<F[+X]F[-X]+>>X:50 && X:>>F[-X]F[+X]->>X:50
            // Angle => 20 Itteration => 5
            List<String> regles = new ArrayList<>();
            regles.add("F:FF:100");
            regles.add("X:<<F[+X]F[-X]+>>X:50");
            regles.add("X:>>F[-X]F[+X]->>X:50");
            this.setConfiguration("X", 20f, 5, regles);
            this.genererButtonListener(event);

        }
        if (event.getSource().equals(this.windows.getToolbar().getArbre6Button())) {
            // Axiom => F Règle => F:FF+[+F-F-F]-[-F+F+F]:100 Angle => 22.5 Itteration => 4
            List<String> regles = new ArrayList<>();
            regles.add("F:FF+[+F-F-F]-[-F+F+F]:100");
            this.setConfiguration("F", 22.5f, 4, regles);
            this.genererButtonListener(event);

        }
        if (event.getSource().equals(this.windows.getToolbar().getArbre7Button())) {
            // Axiom => F Règle => F:F<[+<F]F<[-<F]F:100 Angle => 25.7 Itteration => 4
            List<String> regles = new ArrayList<>();
            regles.add("F:F<[+<F]F<[-<F]F:100");
            this.setConfiguration("F", 25.7f, 4, regles);
            this.genererButtonListener(event);

        }

        if (event.getSource().equals(this.windows.getToolbar().getArbre8Button())) {
            // Axiom => Y Règle => X:X[-FFF][+FFF]FX:100 and Y:YFX[+Y][-Y]:100 Angle => 25.7 Itteration => 5
            List<String> regles = new ArrayList<>();
            regles.add("X:X[-FFF][+FFF]FX:100");
            regles.add("Y:YFX[+Y][-Y]:100");
            this.setConfiguration("Y", 25.7f, 5, regles);
            this.genererButtonListener(event);

        }

        if (event.getSource().equals(this.windows.getToolbar().getArbre9Button())) {
            // Axiom => F Règle => F:F[+FF][-FF]F[-F][+F]F:100 Angle => 35 Itteration => 4
            List<String> regles = new ArrayList<>();
            regles.add("F:F[+FF][-FF]F[-F][+F]F:100");
            this.setConfiguration("F", 35f, 4, regles);
            this.genererButtonListener(event);

        }

        if (event.getSource().equals(this.windows.getToolbar().getArbre10Button())) {
            // Axiom => FX Règle => X:>[-FX]+FX:100 Angle => 40 Itteration => 12
            List<String> regles = new ArrayList<>();
            regles.add("X:>[-FX]+FX:100");
            this.setConfiguration("FX", 40f, 12, regles);
            this.genererButtonListener(event);

        }

        if (event.getSource().equals(this.windows.getToolbar().getArbre11Button())) {
            // Axiom => F+XF+F+XF Règle => X:XF-F+F-XF+F+XF-F+F-X:100 Angle => 90 Itteration => 5
            List<String> regles = new ArrayList<>();
            regles.add("X:XF-F+F-XF+F+XF-F+F-X:100");
            this.setConfiguration("F+XF+F+XF", 90f, 5, regles);
            this.genererButtonListener(event);

        }

        if (event.getSource().equals(this.windows.getToolbar().getArbre12Button())) {
            // Axiom => F+F+F+F Règle => F:F+F-F-FF+F+F-F:100 Angle => 90 Itteration => 5
            List<String> regles = new ArrayList<>();
            regles.add("F:F+F-F-FF+F+F-F:100");
            this.setConfiguration("F+F+F+F", 90f, 5, regles);
            this.genererButtonListener(event);

        }

        /*
            Des regles à essayer sur l'interface graphique
            Crystal : axiom = F+F+F+F Règles : F:FF+F++F+F:100 angle = 90
            Peano Curve : Axiom : X Règles : X:XFYFX+F+YFXFY-F-XFYFX and Y:YFXFY-F-XFYFX+F+YFXFY:100 angle = 90
            Quadratic Snowflake : Axiom : F Règles : F:F-F+F+F-F:100 angle = 90
            Variation by Hasan Hosam : axiom = X+X+X+X+X+X+X+X Règles : X:X+YF++YF-FX--FXFX-YF+X:100 and Y:-FX+YFYF++YF+FX--FX-YF:100 angle = 45
            Board : axiom = F+F+F+F Règles : F:FF+F+F+F+FF angle = 90
            Sierpinski Arrowhead : axiom = YF Règles : X:YF+XF+Y:100 and Y:XF-YF-X:100 angle = 60
            Von Koch Snowflake : axiom = F++F++F Règles : F:F-F++F-F:100 angle = 60
            Rings : axiom = F+F+F+F Règles : F:FF+F+F+F+F+F-F:100 angle = 90
        */
        // F → FX[FX[+XF]] and X → FF[+XZ++X-F[+ZX]][-X++F-X] and Z → [+F-X-F][++ZX]
        // Axiom => X Regle => F → FF and X → F+[-F-XF-X][+FF][--XF[+X]][++F-X] Angle =>
        // 25° Itteration => 7

    }

    /*
     * Gestion dynamique de la création et la suppression de nouvelle règle
     * 
     * @ensure Ajouter un JTextField dans la partie configuration en cas de Clique
     * sur New Rule
     * 
     * @ensure Désactiver le bouton New Rule en cas de 4 JTextField dans la
     * configuration
     * 
     * @ensure Ajouter un bouton permettant de supprimer le JTextField ajouté
     * 
     */
    private void newRegleButtonListener(ActionEvent event) {
        List<JTextField> listeRegleTextField = this.windows.getConfiguration().getListeRegleTextField();
        List<JLabel> listeLabels = this.windows.getConfiguration().getListeLabels();
        JPanel configPanel = this.windows.getConfiguration().getConfigPanel();
        JButton newruleBtn = this.windows.getConfiguration().getNewRulesButton();

        JButton removeBtn = new JButton("X");
        removeBtn.setFont(Configuration.FIELD_FONT);
        removeBtn.setBackground(Color.RED);
        JLabel ruleTexte = new JLabel("Règle " + (listeRegleTextField.size() + 1));
        // ruleTexte.setFont(Configuration.FIELD_FONT);
        ruleTexte.setPreferredSize(new Dimension(55, 20));
        JTextField newregleJTextField = new JTextField();
        newregleJTextField.setPreferredSize(Configuration.FIELD_DIMENSION);
        newregleJTextField.setFont(Configuration.FIELD_FONT);
        listeRegleTextField.add(newregleJTextField);
        JPanel newPanel = new JPanel();
        newPanel.setPreferredSize(Configuration.PANEL_DIMENSION);
        newPanel.setLayout(Configuration.PANEL_LAYOUT);

        newPanel.add(ruleTexte);
        newPanel.add(removeBtn);
        newPanel.add(newregleJTextField);

        /*
         * Comportement du clique sur le button x affiché a côté de la nouvelle règle
         * Listerner sur le bouton X ajouté en même temps que le JTextField
         */
        removeBtn.addActionListener((e) -> {

            if (listeLabels != null) {
                listeLabels.remove(ruleTexte);
            }

            newPanel.getParent().remove(newPanel);
            listeRegleTextField.remove(newregleJTextField);
            listeLabels.remove(ruleTexte);
            configPanel.repaint();
            configPanel.setVisible(false);
            configPanel.setVisible(true);
            newruleBtn.setEnabled(true);
        });
        // Mise a jour du panel des paramètre apres l'ajout d'une regle pour le rendre
        // dynamique

        listeLabels.add(ruleTexte);
        configPanel.add(newPanel);
        configPanel.revalidate();
        configPanel.repaint();
        configPanel.setVisible(false);
        configPanel.setVisible(true);
    }

    /**
     * Méthode appelée lorsque l'utilisateur clique sur le bouton "Clear".
     * Elle réinitialise les champs de configuration et efface le rendu affiché.
     * @param e L'événement déclenché par le clic sur le bouton.
     */
    private void clearButtonListener(ActionEvent e) {
        this.windows.getConfiguration().getAxiom().setText("");
        this.windows.getConfiguration().getAngle().setText("");
        this.windows.getConfiguration().getItteration().setText("");
        for (JTextField field : this.windows.getConfiguration().getListeRegleTextField()) {
            field.setText("");
        }
        this.windows.getZoneRendu().getRendu().removeAll();
        this.windows.getZoneRendu().getRendu().repaint();
        this.windows.getZoneRendu().getRendu().setVisible(false);
        this.windows.getZoneRendu().getRendu().setVisible(true);
       // System.out.println("btnClear selected");
    }

    /**
     * Méthode appelée lorsque l'utilisateur clique sur l'option "A propos" du menu.
     * Elle affiche une boîte de dialogue d'aide.
     * @param event L'événement déclenché par la sélection de l'option.
     */
    private void helpItemListener(ActionEvent event) {
        Help help = new Help();
        help.setVisible(true);
    }

     /**
     * Méthode appelée lorsqu'un bouton de choix de rendu est cliqué.
     * Elle déclenche la génération du rendu correspondant en fonction du bouton cliqué.
     * @param e L'événement déclenché par le clic sur le bouton.
     */

    public void renduButtonListerner(ActionEvent e){
        if(e.getSource().equals(this.windows.getZoneRendu().getRendu2DBoutton())){
            this.genererButtonListener(e);
        }
        if(e.getSource().equals(this.windows.getZoneRendu().getRendu3DBoutton())){
            //System.out.println("Btn 3d clicked");
            this.genererButtonListener(e);
        }

    }
    
       /**
     * Méthode appelée lorsqu'un bouton de l'interface est cliqué.
     * Elle gère les actions à effectuer en fonction du bouton cliqué.
     * @param event L'événement déclenché par le clic sur le bouton.
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource().equals(this.windows.getMenu().getQuitte())) {
            this.windows.dispose();
        }
    }
   
    /**
     * Méthode qui vérifie si la configuration des paramètres est correcte.
     * @return true si la configuration est valide, sinon false.
     */

    private boolean goodConfiguration() {
        String axiom = this.windows.getConfiguration().getAxiom().getText();
        List<JTextField> listeRegleTextField = this.windows.getConfiguration().getListeRegleTextField();

        for (int i = 0; i < axiom.length(); i++) {
            if (Character.isDigit(axiom.charAt(i))) {
                this.errorSMS = "Axiom : Que des lettres svp !!!";
                return false;
            }
        }

        try {
            int nbItt = Integer.parseInt(this.windows.getConfiguration().getItteration().getText());
            Float angle = Float.parseFloat(this.windows.getConfiguration().getAngle().getText());
            if (nbItt > 15 || nbItt < 1) {
                this.errorSMS = "Nombre d'ittération > 9 ou < 0. ";
                return false;
            }
            if (angle < 0 || angle > 360) {
                this.errorSMS = "L'angle > 360 0 ou < 0. ";
                return false;
            }
        } catch (Exception e) {
            this.errorSMS = "Que des chiffres pour l'ittération et l'angle. ";
            return false;
        }

        try {
            for (JTextField regle : listeRegleTextField) {
                String texte[] = regle.getText().split(":");
                String initChaine = texte[0];
                String nextChaine = texte[1];
                Double.parseDouble(texte[2]);// Juste pour vérifier si c'est un nombre
                if (!initChaine.isEmpty() && !nextChaine.isEmpty()) {
                    for (int i = 0; i < initChaine.length(); i++) {
                        if (Character.isDigit(initChaine.charAt(i))) {
                            this.errorSMS = "Mauvaise synthase au niveau d'un des chaines de départ des règles.";
                            return false;
                        }
                    }
                    for (int i = 0; i < nextChaine.length(); i++) {
                        if (Character.isDigit(nextChaine.charAt(i))) {
                            this.errorSMS = "Mauvaise synthase au niveau d'un des chaines suivantes d'une des règles.";
                            return false;
                        }
                    }
                } else {
                    return false;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            this.errorSMS = "Règles : Mauvaise synthase !!!";
            return false;
        } catch (Exception e) {
            this.errorSMS = "Le pourcentage doit être un nombre";
            return false;
        }
        return true;

    }

     /**
     * Méthode permettant de définir la configuration initiale de l'interface graphique.
     * @param axiom Axiome de départ.
     * @param angle Angle de rotation.
     * @param nbItt Nombre d'itérations.
     * @param listRegles Liste des règles.
     */

    private void setConfiguration(String axiom, Float angle, int nbItt, List<String> listRegles) {
        this.windows.getConfiguration().getAxiom().setText(axiom);
        this.windows.getConfiguration().getAngle().setText(String.valueOf(angle));
        this.windows.getConfiguration().getItteration().setText(String.valueOf(nbItt));
        int nbRegle = listRegles.size();

        this.windows.getConfiguration().setDefaultConfiguration();

        if (nbRegle == 1) {
            this.windows.getConfiguration().getListeRegleTextField().get(0).setText(listRegles.get(0));
        } else {
            // On crée les FieldText manquant
            for (int i = 1; i <= listRegles.size() - 1; i++) {
                this.newRegleButtonListener(null);
            }
            // On remplit les fieldTexts avec les règles
            for (int i = 0; i < this.windows.getConfiguration().getListeRegleTextField().size(); i++) {
                this.windows.getConfiguration().getListeRegleTextField().get(i).setText(listRegles.get(i));
            }
        }

    }


    public Interface getWindows() {
        return this.windows;
    }

    public Generator getGenerateur() {
        return this.generateur;
    }
}
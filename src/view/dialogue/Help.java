package view.dialogue;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 * Cette classe représente la fenêtre d'aide de l'application.
 * Elle fournit des informations sur l'utilisation de l'interface.
 * 
 * @author Patrice COTCHO
 */
public class Help extends JFrame {
    
    /**
     * Constructeur de la classe Help.
     * Initialise la fenêtre d'aide avec les informations sur l'interface.
     */
    public Help() {
        super("A propos");

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(950, 600);
        this.setLocationRelativeTo(null);

        JTextPane jTextPane = new JTextPane();
        Style style2 = jTextPane.addStyle("style2", jTextPane.getStyle(""));
        StyleConstants.setFontSize(style2, 18);
        String s1 = "\t\t\tBonjour et bienvenu dans l'application d'interpréteur de L-système.\n" +
                "\n\n \t\t\t\t\t" +
                "Explication des champs :\n\n\n" +

                "#- La zone de paramétrage à droite \n" +
                "\tAxiom      : Point de départ. Il représente la chaîne initiale à partir de laquelle on démarre\n" +
                "\tItération  : Entier positif représentant le nombre d'itérations à faire\n" +
                "\tAngle       : Floatant en degré représentant un angle de rotation \n" +
                "\tRègle       : La liste des contraintes qui seront appliquées à chaque itération\n" +
                "\n" +

                "#- Boutons de contrôles:\n" +
                "\tGenerate  : Le bouton permettant de visualiser le L-système \n" +
                "\tClear: Ce bouton permet de tout remettre à zéro\n" +
                "\tNew Rule: Ce bouton permet d'ajouter un champ de règle.\n" +

                "\n" +
                "# Toolbar\n" +
                "\t- La toolbar est composée de 7 boutons correspondant à des exemples d'arbres.\n" +
                "\t- Un clic sur l'un des boutons permet de dessiner l'arbre correspondant\n" +
                "\t- La configuration est automatiquement complétée dans la zone de configuration\n" +

                "\n" +
                "# Menu\n" +
                "\t- Le menu est composé de deux items. \n" +
                "\t- L'un proposant de quitter et l'autre proposant une explication plus claire du\n" +
                "\t  fonctionnement de l'interface utilisateur.\n" +

                "\n" +
                "# Zone de rendu\n" +
                "\t- Deux cases à cocher permettent de sélectionner le rendu souhaité.\n" +
                "\t- Le rendu 3D permet de zoomer et dézoomer à l'aide des \n" +
                "\tboutons (+ et -) ainsi qu'une possibilité de se déplacer autour de l'arbre à \n" +
                "\tl'aide de clics glissés avec la souris dans la zone\n" +
                "\n" +
                "# Interprétation des instructions de paramétrage\n" +
                "\t+ : Tourner à gauche d’un angle α (∈ S) ;\n" +
                "\t- : Tourner à droite d’un angle α (∈ S) ;\n" +
                "\t[ : Sauvegarder la position courante (∈ S) ;\n" +
                "\t] : Restaurer la dernière position sauvegardée (∈ S).\n" +
                "\tToute autre lettre non citée : Se déplacer d’un pas unitaire (∈ V) ;\n" +
                "\n" +
                "     \t-Ajouter à ces instructions ci-dessus pour le rendu 3D on a:\n" +
                "\n" +
                "\tB: S’incliner vers (tangage) le bas d’un angle δ\n" +
                "\tH: S’incliner vers (tangage) le haut d’un angle δ\n" +
                "\t< Rouler à gauche (roulis) d’un angle δ\n" +
                "\t> Rouler à droite (roulis) d’un angle δ\n" +
                "\t\n" +
                "@Ce projet a été réalisé par:\n" +
                "- Boluwatife ADEKOYA    \n" +
                "- Patrice COTCHO  \n" +
                "- Aissatou DIALLO           \n" +
                "- Jérémie LAYIZIA   ";

        StyledDocument sDoc = (StyledDocument) jTextPane.getDocument();

        JScrollPane jScrollPane = new JScrollPane(jTextPane);
        this.add(jScrollPane);
        try {
            sDoc.insertString(0, s1, style2);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }
}
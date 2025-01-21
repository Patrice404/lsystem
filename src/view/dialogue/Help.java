package view.dialogue;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 * Aide cette classe definie des information et mode d'emploie de l'interface !
 * @author  Elhadj Alseiny20
 */
public class Help extends JFrame {
    public Help (){
        super("A propos");

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(950,600);
        this.setLocationRelativeTo(null);

        JTextPane jTextPane = new JTextPane();
       
        Style style2 = jTextPane.addStyle("style2", jTextPane.getStyle(""));
        StyleConstants.setFontSize(style2, 18);
        String s1 = "\t\t\tBonjour et bienvenu dans l'application d'interpreter de lsystem.\n" +
                "\n\n \t\t\t\t\t" +
                "Explication des champs :\n\n\n" +

                "#- La zone de paramétrage à droite \n" +
                "\tAxiom      : Point de depart. Il represente la chaine initiale à partir de laquelle on démarre\n" +
                "\tItération  : Entier positif representant le nombre d'ittération à faire\n" +
                "\tAngle       : Floatant en degré representant une l'angle de rotation \n" +
                "\tRègle       : La liste des contraintes qui seront appliquées à chaque itération\n" +
                "\n" +

                "#- Boutons de controles:\n" +
                "\tGenerate  : Le bouton permettant de visualiser le lsystème \n" +
                "\tClear: Ce bouton permet de tout remettre à zéro\n" +
                "\tNew Rule: Ce bouton permet d'ajouter un champ de règle. 4 au maximum\n" +

                "\n" +
                "# Toolbar\n" +
                "\t- La toolbar est composé de ?? boutons correspondant à des exemples d'arbre.\n" +
                "\t- Un clique sur l'un des boutons permet de dessiner l'arbre correspondant\n" +
                "\t- La configuration est automatiquement completée dans la zone de configuration\n" +

                "\n" +
                "# Menu\n" +
                "\t- Le menu est composé de deux items. \n" +
                "\t- L'un proposant de quitter et l'autre proposant une explication plus claire du\n" +
                "\t  fonctionnement et de l'interface utilisateur.\n" +

                "\n" +
                "# Zone de rendu\n" +
                "\t- Deux cases à cocher permettent de selectionner le rendu souhaité.\n" +
                "\t- Le rendu 3D est mini de la possibilté de zoomer et dezoomer à l'aide des \n" +
                "\tboutons (+ et -) ainsi qu'une possibilité de se déplacer autour de l'arbre à \n" +
                "\tl'aide de cliques glisse avec la sourie dans la zone\n" +
                "\n" +
                "# Interprétation des instructions parametrage\n" +
                "\t+ : Tourner à gauche d’angle α (∈ S) ;\n" +
                "\t- : Tourner à droite d’un angle α (∈ S) ;\n" +
                "\t[ : Sauvegarder la position courante (∈ S) ;\n" +
                "\t] : Restaurer la dernière position sauvée (∈ S).\n" +
                "\tF ainsi que tout autre lettre non cité : Se déplacer d’un pas unitaire (∈ V) ;\n" +
                "\n" +
                "     \t-Ajouter à ces instructions ci-déssus pour le rendue 3D on a:\n" +
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
                "- Jérémie .....   ";
        
        StyledDocument sDoc = (StyledDocument)jTextPane.getDocument();

        JScrollPane jScrollPane = new JScrollPane(jTextPane);
        this.add(jScrollPane);
        //jTextPane.setEnabled(false);
        try {
            sDoc.insertString(0, s1, style2);
        } catch (BadLocationException e) { }
    }
}

package view.dialogue;

import java.awt.*;

import javax.swing.*;

/**
 * Cette classe représente une boîte de dialogue d'erreur.
 * Elle affiche un message d'erreur à l'utilisateur.
 * 
 * @author Patrice COTCHO
 */
public class Dialog extends JDialog {

    /**
     * Constructeur de la classe ErrorDialog.
     * 
     * @param frame la fenêtre parente de la boîte de dialogue
     * @param title le titre de la boîte de dialogue
     * @param info le message d'erreur à afficher
     * @param modal spécifie si la boîte de dialogue est modale ou non
     */
    public Dialog(Frame frame, String title, String info, boolean modal) {
        super(frame, title, modal);
        JPanel textPanel = new JPanel();
        textPanel.setPreferredSize(new Dimension(400, 60));
        JLabel textLabel = new JLabel(info);
        textLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        if(title.equals("Mauvaise configuration")){
            textLabel.setForeground(Color.RED);
        }else{
            textLabel.setForeground(Color.GRAY);
        }
        
        textPanel.add(textLabel);
        this.add(textPanel);
        this.setLocationRelativeTo(null); 
        this.pack();
        this.setVisible(true);
    }

    /**
     * Constructeur de la classe ErrorDialog avec un titre par défaut.
     * 
     * @param frame la fenêtre parente de la boîte de dialogue
     * @param info le message d'erreur à afficher
     */
    public Dialog(Frame frame, String title, String info) {
        this(frame, title, info, true);
    }

}
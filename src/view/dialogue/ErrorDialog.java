package view.dialogue;

import java.awt.*;

import javax.swing.*;

public class ErrorDialog extends JDialog{

    private JButton okBtn;
    public ErrorDialog(Frame frame,String title,String info,boolean modale){
        super(frame,title,modale);
        JPanel textPanel = new JPanel();
        textPanel.setPreferredSize(new Dimension(400,60));
        JLabel textLabel = new JLabel(info);
        textLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        textLabel.setForeground(Color.RED);
        textPanel.add(textLabel);
        this.add(textPanel);
        this.setLocationRelativeTo(null); // centrage écran
        this.pack();
        this.setVisible(true);
    }
    public ErrorDialog(Frame frame,String info){
        this(frame,"Erreur de configuration",info,true);
    }
    public JButton getOkBtn() {
        return okBtn;
    }
    
    
}

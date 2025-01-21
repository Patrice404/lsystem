package view;

import java.awt.event.KeyEvent;
import javax.swing.*;

/*
 * Cette classe represente la bar de menu qui apparait sur l'interface graphique de l'utilisateur
 * @author Patrice D. Z. COTCHO
 */
public class Menu extends JMenuBar {

    private JMenuItem apropos;
    private JMenuItem quitte;

    /*
     * Constructeur de la class Menu
     */
    public Menu() {
        super();
        this.configureMenu();

    }

    /*
     * Méthode de configuration du menu
     */
    private void configureMenu() {

        this.apropos = new JMenuItem("Help");
        this.quitte = new JMenuItem("Exit");
        //quitte.setIcon(new ImageIcon("icons/exit.png"));
        quitte.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_DOWN_MASK));

        JMenu menuFile = new JMenu("File");
        menuFile.setMnemonic('F');
        menuFile.add(quitte);

        JMenu menuAide = new JMenu("Help");
        menuAide.setMnemonic('H');
        menuAide.add(apropos);

        this.add(menuFile);
        this.add(menuAide);

        this.setVisible(true);

    }

    public JMenuItem getApropos(){
        return this.apropos;
    }

    public JMenuItem getQuitte(){
        return this.quitte;
    }

}
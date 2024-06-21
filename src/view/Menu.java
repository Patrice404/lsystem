/**
 * Cette classe représente la barre de menu qui apparaît sur l'interface graphique de l'utilisateur.
 * Elle permet d'accéder à différentes fonctionnalités telles que l'aide et la sortie de l'application.
 * 
 * @author Patrice D. Z. COTCHO
 */
package view;

import java.awt.event.KeyEvent;
import javax.swing.*;

public class Menu extends JMenuBar {

    private JMenuItem apropos;
    private JMenuItem quitte;

    /**
     * Constructeur de la classe Menu.
     * Initialise la configuration du menu.
     */
    public Menu() {
        super();
        this.configureMenu();
    }

    /**
     * Méthode de configuration du menu.
     * Initialise les éléments du menu et les ajoute à la barre de menu.
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

    /**
     * Récupère l'élément de menu "Help".
     * 
     * @return L'élément de menu "Help".
     */
    public JMenuItem getApropos(){
        return this.apropos;
    }

    /**
     * Récupère l'élément de menu "Exit".
     * 
     * @return L'élément de menu "Exit".
     */
    public JMenuItem getQuitte(){
        return this.quitte;
    }
}
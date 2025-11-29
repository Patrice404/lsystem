package view;

import java.util.List;
import java.util.ArrayList;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import controler.AppController;
import model.*;
import utils.GeneratorException;

public class Main {
    public static void main(String[] args) throws GeneratorException {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        List<Rule> listeRegles = new ArrayList<>();
        listeRegles.add(new Rule("F", "FF"));

        Generator generateur = new Generator("", listeRegles);

        
        Interface windows = new Interface();

        AppController controller = new AppController(windows, generateur, listeRegles);

    }
}

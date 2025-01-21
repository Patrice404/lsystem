package test;
import java.util.ArrayList;
import java.util.List;
import junit.framework.*;
import model.Generator;
import model.Rule;

/*
 * @author Aissatou DIALLO
 */
public class TestGenerateur extends TestCase{
    public void testEtatSuivant() throws Exception{
        Rule regle1 = new Rule("F", "FF");
        Rule regle2 = new Rule("X", "F-[[X]+X]+F[+FX]-X");
        List <Rule> regles = new ArrayList<>();
        regles.add(regle1);
        regles.add(regle2);
        Generator generateur = new Generator("X",regles);
        assertEquals("F-[[X]+X]+F[+FX]-X",generateur.generate(1));

        //Generateur generateur1 = new Generateur("F-[[X]+X]+F[+FX]-X",regles,2);
        //assertEquals("FF-[[F-[[X]+X]+F[+FX]-X]+F-[[X]+X]+F[+FX]-X]+FF[+FFF-[[X]+X]+F[+FX]-X]-F-[[X]+X]+F[+FX]-X",generateur1.generate());
    }
    public static void main(String[] args) {
        junit.textui.TestRunner.run(new TestSuite(TestGenerateur.class));

    }
}


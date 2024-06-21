package test;
import java.util.ArrayList;
import java.util.List;
import junit.framework.*;
import model.Generator;
import model.Rule;
import utils.GeneratorException;

/***
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
    
    }

        
        public void testGenerate() throws Exception{
           
            Rule rule1 = new Rule("F", "F<[+<F]F<[-<F]F",100d) ;
            List < Rule> rules = new ArrayList<>();
            rules.add(rule1);
            Generator generate = new Generator ("F",rules);
            assertEquals("F<[+<F]F<[-<F]F<[+<F<[+<F]F<[-<F]F]F<[+<F]F<[-<F]F<[-<F<[+<F]F<[-<F]F]F<[+<F]F<[-<F]F",generate.generate(2));


            Rule rule2 = new Rule("X","F-[[X]+X]+F[+FX]-X",100d);
            List < Rule> rules1 = new ArrayList<>();
            rules1.add(rule2);
            generate = new Generator("X", rules1);
            assertEquals("F-[[F-[[F-[[X]+X]+F[+FX]-X]+F-[[X]+X]+F[+FX]-X]+F[+FF-[[X]+X]+F[+FX]-X]-F-[[X]+X]+F[+FX]-X]+F-[[F-[[X]+X]+F[+FX]-X]+F-[[X]+X]+F[+FX]-X]+F[+FF-[[X]+X]+F[+FX]-X]-F-[[X]+X]+F[+FX]-X]+F[+FF-[[F-[[X]+X]+F[+FX]-X]+F-[[X]+X]+F[+FX]-X]+F[+FF-[[X]+X]+F[+FX]-X]-F-[[X]+X]+F[+FX]-X]-F-[[F-[[X]+X]+F[+FX]-X]+F-[[X]+X]+F[+FX]-X]+F[+FF-[[X]+X]+F[+FX]-X]-F-[[X]+X]+F[+FX]-X",generate.generate(3));
        }

        public void testContructeur() throws GeneratorException{
            Rule rule1 = new Rule("F", "F<[+<F]F<[-<F]F",100d) ;
            List < Rule> rules = new ArrayList<>();
           
            rules.add(rule1);
            Generator generator1 = new Generator("X",rules);
            assertEquals("X",generator1.getAxiom());  
            assertEquals(rules.size(),generator1.getRegles().size());
            for(int i = 0;i<rules.size();i++){
                assertEquals(rules.get(i), generator1.getRegles().get(i));
            }

            Rule rule2 = new Rule("X","F-[[X]+X]+F[+FX]-X",100d);
            Rule rule3 = new Rule("F","F-[[X]+X]+F[+FX]-X",100d);
            List < Rule> rules1 = new ArrayList<>();
            rules1.add(rule2);
            rules1.add(rule3);
            Generator generator2 = new Generator ("F",rules1);
            assertEquals("F",generator2.getAxiom());  
            assertEquals(rules1.size(),generator2.getRegles().size());
            for(int j= 0; j<rules1.size();j++){
                assertEquals(rules1.get(j), generator2.getRegles().get(j));
            }  
        }
        public static void main(String[] args) {
        junit.textui.TestRunner.run(new TestSuite(TestGenerateur.class));

    }
}


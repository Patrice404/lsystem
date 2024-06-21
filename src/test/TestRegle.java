package test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.*;
import model.Rule;

/**
 * @author Boluwatife E. ADEKOYA
 */
public class TestRegle extends TestCase{

    public void testContructeur(){
        Rule regle1 = new Rule("F", "FF");
        Rule regle2 = new Rule("X", "F-[[X]+X]+F[+FX]-X");
        Rule regle3 = new Rule("F", "F:F[+F]F[-F][F]", 40.0);
        assertEquals("F", regle1.getInitChaine());  
        assertEquals("FF", regle1.getNextChaine());
        assertEquals("X", regle2.getInitChaine());
        assertEquals("F-[[X]+X]+F[+FX]-X", regle2.getNextChaine());
        assertEquals("F", regle3.getInitChaine());
        assertEquals("F:F[+F]F[-F][F]", regle3.getNextChaine());
        assertEquals(40.0, regle3.getPourcentage());   
    }

     public void testRulesIsCorrect(){
        Rule regle1 = new Rule("F", "FF");
        Rule regle2 = new Rule("X", "-F[+F][--X]+F-F[++X]-X",40d);
        Rule regle3 = new Rule("X", "+F[-F][++X]-F+F[---X]+X",60d);
        List <Rule> regles = new ArrayList<>();
        regles.add(regle1);
        regles.add(regle2);
        regles.add(regle3);
       
        Rule regle4 = new Rule("X","<<F[+X]F[-X]+>>X",50d);
        Rule regle5 = new Rule("X",">>F[-X]F[+X]->>X",50d);
        List <Rule> regles2 = new ArrayList<>();
        regles2.add(regle1);
        regles2.add(regle4);
        regles2.add(regle5);

        assertTrue(Rule.rulesIsCorrect(regles));
        assertTrue(Rule.rulesIsCorrect(regles2));
      
    }

    public void testRulesThatStartFrom(){
        Rule regle1 = new Rule("F", "FF");
        Rule regle2 = new Rule("X", "-F[+F][--X]+F-F[++X]-X",40d);
        Rule regle3 = new Rule("X", "+F[-F][++X]-F+F[---X]+X",60d);
        List <Rule> regles = new ArrayList<>();
        regles.add(regle1);
        regles.add(regle2);
        regles.add(regle3);

        List<Rule> expected = new ArrayList<>();
        expected.add(regle2);
        expected.add(regle3);

        List<Rule> actual = Rule.rulesThatStartFrom("X", regles);
        assertEquals(expected.size(), actual.size());
        for(int i=0; i<actual.size(); i++){
            assertEquals(expected.get(i), actual.get(i));
        }

    }

    public void testGetInitOfRules(){
        Rule regle1 = new Rule("F", "FF");
        Rule regle2 = new Rule("X", "-F[+F][--X]+F-F[++X]-X",40d);
        Rule regle3 = new Rule("X", "+F[-F][++X]-F+F[---X]+X",60d);
        Rule regle4 = new Rule("Q", "+F[-F][++X]-F+F[---X]+X",50d);
        Rule regle5 = new Rule("Q", "FF",50d);
        Rule regle6 = new Rule("Z", "+F[---X]+X",60d);
        Rule regle7 = new Rule("Z", "+--X]+X",40d);
       
        List <Rule> regles = new ArrayList<>();
        regles.add(regle1);
        regles.add(regle2);
        regles.add(regle3);
        regles.add(regle4);
        regles.add(regle5);
        regles.add(regle6);
        regles.add(regle7);

        List<String> expected = new ArrayList<String>(); 
        expected.add("F");
        expected.add("X");
        expected.add("Q");
        expected.add("Z");

        List<String> actual = Rule.getInitOfRules(regles);
        assertEquals(expected.size(), actual.size());
        for(int i=0; i<actual.size(); i++){
            assertEquals(expected.get(i), actual.get(i));
        }
    }
   
    public static void main(String[] args) {
        junit.textui.TestRunner.run(new TestSuite(TestRegle.class));
    }

}

package test;

import junit.framework.*;
import model.Rule;

/*
 * @author Boluwatifè E. ADEKOYA
 */
public class TestRegle extends TestCase{

    public void testContructeur(){
        Rule regle1 = new Rule("F", "FF");
        Rule regle2 = new Rule("X", "F-[[X]+X]+F[+FX]-X");
        assertEquals("F", regle1.getInitChaine());  
        assertEquals("FF", regle1.getNextChaine());
        assertEquals("X", regle2.getInitChaine());
        assertEquals("F-[[X]+X]+F[+FX]-X", regle2.getNextChaine());

    
    }
    
    public static void main(String[] args) {
        junit.textui.TestRunner.run(new TestSuite(TestRegle.class));
    }

}

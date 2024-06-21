package model;

import java.util.ArrayList;
import java.util.List;

import utils.Function;

/**
 * Classe qui permet de représenter une règle.
 * Une règle permet de spécifier la transformation à effectuer sur un symbole pour passer de l'état actuel au suivant
 * 
 * @author Aissatou DIALLO
 */
public class Rule {
    private String initChaine, nextChaine;
    private Double pourcentage;

    /**
     * Le constructeur de la classe.
     * 
     * @param initChaine la chaîne initiale, représentant le symbole à transformer.
     * @param nextChaine la chaîne suivante, représentant la transformation à appliquer sur le symbole.
     * @param pourcentage le pourcentage associé à cette règle, déterminant la probabilité d'application de la règle.
     * 
     * @throws IllegalArgumentException si le pourcentage est inférieur à 0 ou supérieur à 100.
     */
    public Rule(String initChaine, String nextChaine, Double pourcentage) throws IllegalArgumentException {
        if (pourcentage < 0 || pourcentage > 100) {
            throw new IllegalArgumentException();
        } else {
            this.initChaine = initChaine;
            this.nextChaine = nextChaine;
            this.pourcentage = pourcentage;
        }
    }

    /**
     * Constructeur surchargé qui initialise le pourcentage à 100 par défaut.
     * 
     * @param initChaine la chaîne initiale, représentant le symbole à transformer.
     * @param nextChaine la chaîne suivante, représentant la transformation à appliquer sur le symbole.
     */
    public Rule(String initChaine, String nextChaine) {
        this(initChaine, nextChaine, 100d);
    }

/**
 * Vérifie si les règles fournies sont correctement définies.
 * 
 * Cette méthode vérifie si les règles fournies respectent les conditions suivantes :
 * - La liste de règles ne doit pas être nulle et doit contenir au moins une règle.
 * - Pour chaque chaîne initiale de règles, la somme des pourcentages associés à ces règles
 *   doit être égale à 100.
 * 
 * Si l'une de ces conditions n'est pas respectée, la méthode retourne false, indiquant que les
 * règles ne sont pas correctes. Sinon, elle retourne true.
 * 
 * @param regles la liste de règles à vérifier.
 * 
 * @return true si les règles sont correctement définies, sinon false.
 */
    public static boolean rulesIsCorrect(List<Rule> regles) {
        if (regles != null && regles.size() > 0) {
            List<String> initOfRules = getInitOfRules(regles);
            for (String string : initOfRules) {
                List<Rule> rules = rulesThatStartFrom(string, regles);
                double sumPourcentage = 0;
                for (Rule rule : rules) {
                    sumPourcentage += rule.getPourcentage();
                }
                if (sumPourcentage != 100d) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

   

    /**
     * Récupère la liste des règles ayant une chaîne initiale spécifique.
     * 
     * Cette méthode parcourt la liste de règles spécifiée et récupère toutes les
     * règles
     * ayant la même chaîne initiale que celle spécifiée en paramètre.
     * 
     * @param chaine la chaîne initiale à partir de laquelle récupérer les règles.
     * @param regles la liste de règles à parcourir.
     * 
     * @return une liste de règles ayant la même chaîne initiale que celle
     *         spécifiée.
     */
    public static List<Rule> rulesThatStartFrom(String chaine, List<Rule> regles) {
        List<Rule> listofRules = new ArrayList<Rule>();
        for (Rule rule : regles) {
            if (rule.getInitChaine().equals(chaine)) {
                listofRules.add(rule);
            }
        }
        return listofRules;
    }


     /**
     * Récupère la liste des chaînes initiales uniques à partir d'une liste de
     * règles.
     * Cette méthode parcourt la liste de règles spécifiée et récupère toutes les
     * chaînes initiales
     * uniques à partir de ces règles. Une chaîne initiale est considérée comme
     * unique si elle n'est pas
     * déjà présente dans la liste des chaînes initiales collectées.
     * 
     * @param list la liste de règles à partir de laquelle récupérer les chaînes
     *             initiales.
     * 
     * @return une liste contenant toutes les chaînes initiales uniques présentes
     *         dans la liste de règles spécifiée.
     */

    public static List<String> getInitOfRules(List<Rule> list) {
        List<String> initOfRules = new ArrayList<>();
        for (Rule regle : list) {
            String init = regle.getInitChaine();
            if (!Function.estPresent(init, initOfRules)) {
                initOfRules.add(init);
            }
        }
        return initOfRules;
    }



    /**
     * Méthode toString qui retourne une représentation textuelle de la règle.
     * 
     * @return une chaîne de caractères représentant la règle.
     */
    public String toString(){
        return this.initChaine+" = " + this.nextChaine;
    }

    public String getInitChaine() {
        return initChaine;
    }

    public void setInitChaine(String initChaine) {
        this.initChaine = initChaine;
    }

    public String getNextChaine() {
        return nextChaine;
    }

    public void setNextChaine(String nextChaine) {
        this.nextChaine = nextChaine;
    }

    public Double getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(Double pourcentage) {
        this.pourcentage = pourcentage;
    }

}
package model;

import java.util.ArrayList;
import java.util.List;

import utils.GeneratorException;
import view.dialogue.ErrorDialog;

/**
 * Class Generateur : Le coeur de l'application
 * Il permet de générer la chaine qui sera intepreter et déssiner sur
 * l'interface graphique
 * Il intègre la notion de systèmes stochastiques
 * 
 * @author Patrice D. Z. COTCHO
 */
public class Generator {
    private String axiom;
    private List<Rule> regles;

   
/* *
 * Constructeur de la classe Generator.
 * 
 * Initialise un générateur avec le symbole initial (axiom) et la liste de règles spécifiés.
 * 
 * @param axiom le symbole initial à partir duquel commencer la génération des symboles suivants.
 * @param regles la liste de règles à utiliser pour la génération des symboles suivants.
 * 
 * @throws GeneratorException si les règles spécifiées ne sont pas correctes. Les règles sont considérées
 * comme incorrectes si :
 *   - La somme des pourcentages associés à toutes les règles ayant la même chaîne initiale n'est pas égale à 100.
 *   - La somme des pourcentages est supérieure à 100 ou inférieure à 0.
 */
     
    public Generator(String axiom, List<Rule> regles) throws GeneratorException {
        if (rulesIsCorrect(regles)) {
            this.axiom = axiom;
            this.regles = regles;
        } else {
            throw new GeneratorException("Somme des % > 100 ou < 0.");
        }

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
    public boolean rulesIsCorrect(List<Rule> regles) {
        if (regles != null && regles.size() > 0) {
            List<String> initOfRules = this.getInitOfRules(regles);
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
     * Calcule l'état suivant d'une chaîne de symboles après une itération.
     * 
     * Cette méthode prend en entrée une chaîne de symboles représentant l'état
     * actuel,
     * et calcule l'état suivant de cette chaîne en se basant sur les règles
     * définies.
     * Pour chaque symbole dans l'état actuel, la méthode cherche une règle
     * correspondante
     * dans la liste des règles actuelles. Si une règle correspondante est trouvée,
     * le
     * symbole est remplacé par la chaîne suivante définie par cette règle. Si
     * aucune règle
     * correspondante n'est trouvée, le symbole est conservé tel quel.
     * 
     * @param etatActuel la chaîne de symboles représentant l'état actuel.
     * 
     * @return la chaîne de symboles représentant l'état suivant après une
     *         itération.
     */
    public String etatSuivant(String etatActuel) {
        String resultat = "";
        List<Rule> randomListOfRules = buildListOfRules(this.regles);
        for (char c : etatActuel.toCharArray()) {
            boolean find = false;
            for (int i = 0; i < randomListOfRules.size(); i++) {
                if (randomListOfRules.get(i).getInitChaine().equals(String.valueOf(c))) {
                    find = true;
                    resultat += randomListOfRules.get(i).getNextChaine();
                    break;
                }
            }
            if (!find) {
                resultat += String.valueOf(c);
            }
        }
        return resultat;
    }

    /**
     * Récupère la liste des chaînes initiales uniques à partir d'une liste de
     * règles.
     * 
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
    public List<String> getInitOfRules(List<Rule> list) {
        List<String> initOfRules = new ArrayList<>();
        for (Rule regle : list) {
            String init = regle.getInitChaine();
            if (!estPresent(init, initOfRules)) {
                initOfRules.add(init);
            }
        }
        return initOfRules;
    }

    /**
     * Vérifie si une chaîne est présente dans une liste de chaînes.
     * 
     * Cette méthode parcourt la liste de chaînes spécifiée et vérifie si la chaîne
     * spécifiée en paramètre est présente dans cette liste.
     * 
     * @param chaine la chaîne à rechercher dans la liste.
     * @param list   la liste de chaînes dans laquelle rechercher.
     * 
     * @return true si la chaîne est présente dans la liste, sinon false.
     */

    public boolean estPresent(String chaine, List<String> list) {
        for (String string : list) {
            if (string.equals(chaine)) {
                return true;
            }
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
    public List<Rule> rulesThatStartFrom(String chaine, List<Rule> regles) {
        List<Rule> listofRules = new ArrayList<Rule>();
        for (Rule rule : regles) {
            if (rule.getInitChaine().equals(chaine)) {
                listofRules.add(rule);
            }
        }
        return listofRules;
    }

    /**
     * Sélectionne aléatoirement une règle à partir d'une liste de règles, en
     * fonction des poids associés à chaque règle.
     * 
     * Cette méthode prend en entrée une liste de règles et sélectionne
     * aléatoirement une règle en fonction des poids
     * associés à chaque règle. Les poids sont déterminés par les pourcentages
     * spécifiés pour chaque règle. Plus le pourcentage
     * est élevé, plus la probabilité que la règle soit sélectionnée est grande.
     * 
     * @param list la liste de règles à partir de laquelle sélectionner une règle
     *             aléatoire.
     * 
     * @return la règle sélectionnée aléatoirement.
     * 
     * @throws IndexOutOfBoundsException si la liste de règles est vide.
     */
    public Rule selectRandomRule(List<Rule> list) throws IndexOutOfBoundsException {
        List<Double> weightList = new ArrayList<>();
        weightList.add(list.get(0).getPourcentage());

        for (int i = 1; i < list.size(); i++) {
            weightList.add(list.get(i).getPourcentage() + weightList.get(i - 1));
        }
        Double randomNumber = Math.random() * 100;
        int indexOfRandomRule = 0;
        for (int i = 0; i < weightList.size(); i++) {
            if ((randomNumber - weightList.get(i)) <= 0) {
                indexOfRandomRule = i;
                break;
            }
        }
        return list.get(indexOfRandomRule);
    }

    /**
     * Construit une liste de règles qui seront utilisées pour une itération.
     * 
     * Cette méthode parcourt la liste des règles spécifiée et sélectionne
     * aléatoirement
     * une règle à partir de chaque ensemble de règles partageant la même chaîne
     * initiale.
     * 
     * @param listOfRules la liste de règles à partir de laquelle construire la
     *                    nouvelle liste.
     * 
     * @return une liste de règles construite à partir de la liste spécifiée, avec
     *         une règle sélectionnée
     *         aléatoirement à partir de chaque ensemble de règles partageant la
     *         même chaîne initiale.
     */

    public List<Rule> buildListOfRules(List<Rule> listOfRules) {
        // initOfRules contient les chaines de départ de l'ensemble des règles
        List<String> initOfRules = getInitOfRules(listOfRules);
        List<Rule> resultat = new ArrayList<Rule>();
        for (String string : initOfRules) {
            // rules contient la liste des règles ayant un même départ
            List<Rule> rules = rulesThatStartFrom(string, listOfRules);
            // On tire parmi ces règles une règle aléatoirement et on l'ajoute à resultat
            resultat.add(selectRandomRule(rules));
        }
        return resultat;

    }

    /*
     * Méthode qui permet de générer la suite de symbole après nbItt ittération
     * 
     * @requires créer un objet Generateur en utilisant le constructeur définie
     * ci-dessus
     * 
     * @return la suite de symbole après nbItt ittération
     */
    public String generate(int nbItt) {
        String etat = String.valueOf(this.axiom);
        for (int i = 0; i < nbItt; i++) {
            etat = etatSuivant(etat);
            if(etat.length()>1000000){
                new ErrorDialog(null, "Calcul trop grand");
                return "";
            }
        }
        return etat;
    }

    public String getAxiom() {
        return axiom;
    }

    public void setAxiom(String init) {
        this.axiom = init;
    }

    public List<Rule> getRegles() {
        return regles;
    }

    public void setRegles(List<Rule> regles) {
        this.regles = regles;
    }

    /**
     * Modifie tous les attributs du générateur d'un seul coup.
     * 
     * Cette méthode permet de définir simultanément le symbole initial (axiom) et
     * la liste de règles à utiliser pour la génération de symboles.
     * 
     * @param axiom  le nouveau symbole initial à définir.
     * 
     * @param regles la nouvelle liste de règles à définir.
     * 
     * @throws GeneratorException si la somme des pourcentages associés aux règles
     *                            ayant la même origine est supérieure à 100 ou
     *                            inférieure à 0.
     */
    public void setGenerateur(String axiom, List<Rule> regles) throws GeneratorException {
        if (rulesIsCorrect(regles)) {
            this.setAxiom(axiom);
            this.setRegles(regles);
        } else {
            throw new GeneratorException("Somme des % > 100 ou < 0.");
        }

    }

}

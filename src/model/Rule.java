package model;

/*
 * Classe qui permet de représenter une règle.
 * Une règle permet de spécifier la transformation à effectuer sur un symbole pour passer de l'état actuel au suivant
 * 
 * @author 
 */
public class Rule {
    private String initChaine, nextChaine;
    private Double pourcentage;

    /*
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

    /*
     * Constructeur surchargé qui initialise le pourcentage à 100 par défaut.
     * 
     * @param initChaine la chaîne initiale, représentant le symbole à transformer.
     * @param nextChaine la chaîne suivante, représentant la transformation à appliquer sur le symbole.
     */
    public Rule(String initChaine, String nextChaine) {
        this(initChaine, nextChaine, 100d);
    }

    /*
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
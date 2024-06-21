package utils;

import java.util.List;

/**
 * Cette classe utilitaire contient des méthodes pour les fonctions mathématiques.
 * 
 * @author Patrice COTCHO
 */
public abstract class Function {

    /**
     * Vérifie si une chaîne de caractères est composée uniquement de chiffres.
     * 
     * @param str la chaîne de caractères à vérifier
     * @return true si la chaîne est composée uniquement de chiffres, sinon false
     */
    public static boolean isDigit(String str) {
        boolean isNumeric = true;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                isNumeric = false;
            }
        }
        return isNumeric;
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
    public static boolean estPresent(String chaine, List<String> list) {
        for (String string : list) {
            if (string.equals(chaine)) {
                return true;
            }
        }
        return false;
    }
  
}

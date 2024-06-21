package utils;

/**
 * Cette classe représente une exception spécifique pour les erreurs liées à la génération.
 * Elle étend la classe Exception de base.
 * 
 * @author Patrice COTCHO
 */
public class GeneratorException extends Exception {
    
    /**
     * Constructeur avec un message d'erreur.
     * 
     * @param message le message d'erreur
     */
    public GeneratorException(String message) {
        super(message);
    }

    /**
     * Constructeur par défaut.
     */
    public GeneratorException() {
        super();
    }
}
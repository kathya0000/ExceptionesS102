package S201N3Ex1;

// Excepción personalizada para cuando se introduce un nombre de persona que contiene números.
class ExcepcioNomPersonaIncorrecte extends Exception {
    public ExcepcioNomPersonaIncorrecte(String message) {
        super(message);
    }
}

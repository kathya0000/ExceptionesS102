package S201N3Ex1;

// Excepción personalizada para cuando se introduce un número de asiento incorrecto.
class ExcepcioSeientIncorrecte extends Exception {
    public ExcepcioSeientIncorrecte(String message) {
        super(message);
    }
}
package S201N3Ex1;

// Excepción personalizada para cuando se introduce un número de fila incorrecto.
class ExcepcioFilaIncorrecta extends Exception {
    public ExcepcioFilaIncorrecta(String message) {
        super(message);
    }
}

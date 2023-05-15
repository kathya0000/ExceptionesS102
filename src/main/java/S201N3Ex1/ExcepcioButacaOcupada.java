package S201N3Ex1;

// Excepción personalizada para cuando se intenta reservar una butaca que ya está ocupada.
class ExcepcioButacaOcupada extends Exception {
    public ExcepcioButacaOcupada(String message) {
        super(message);
    }
}

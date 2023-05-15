package S201N3Ex1;

//Excepción personalizada para cuando se intenta anular la reserva de una butaca que no está reservada.
class ExcepcioButacaLliure extends Exception {
    public ExcepcioButacaLliure(String message) {
        super(message);
    }
}

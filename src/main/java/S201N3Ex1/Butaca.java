package S201N3Ex1;

public class Butaca {
    private int numFila;
    private int numAsiento;
    private String persona;
    public Butaca(int numFila, int numAsiento, String persona) {
        this.numFila = numFila;
        this.numAsiento = numAsiento;
        this.persona = persona;
    }

    public int getNumFila() {
        return numFila;
    }

    public int getNumAsiento() {
        return numAsiento;
    }

    public String getPersona() {
        return persona;
    }

    // Devolverá que dos butacas son iguales si la fila y el asiento son iguales.

    public boolean equals(Butaca otraButaca) {
        return this.numFila == otraButaca.getNumFila() && this.numAsiento == otraButaca.getNumAsiento();
    }

    // Devolverá un String con la siguiente información: “Fila: X, Asiento: Y, Persona: Z"
    public String toString() {
        return "Fila: " + numFila + ", Asiento: " + numAsiento + ", Persona: " + persona;
    }
}


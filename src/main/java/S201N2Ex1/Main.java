package S201N2Ex1;

public class Main {
    public static void main(String[] args) {
        byte edad = Entrada.leerByte("Introduce tu edad: ");
        System.out.println("Tu edad es: " + edad);

        float altura = Entrada.leerFloat("Introduce tu altura en metros: ");
        System.out.println("Tu altura es: " + altura);

        String nombre = Entrada.leerString("Introduce tu nombre: ");
        System.out.println("Tu nombre es: " + nombre);

        char genero = Entrada.leerChar("Introduce tu género (M/F): ");
        System.out.println("Tu género es: " + genero);

        boolean esMayorDeEdad = Entrada.leerSiNo("¿Eres mayor de edad? (S/N): ");
        System.out.println("¿Eres mayor de edad? " + esMayorDeEdad);
    }

}

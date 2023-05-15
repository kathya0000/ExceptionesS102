package S201N3Ex1;
import java.util.*;
public class Cine {
    private int numFilas;
    private int numAsientoPorFila;
    private GestionButaca gestionButacas;


    public Cine() {
        gestionButacas = new GestionButaca();
        pedirDatosIniciales();
    }

    // Empezará la aplicación. Llamará al método menú y en función del número devuelto, llamará al método correspondiente.
    public void iniciar() throws ExcepcioButacaLliure {
        int opcio;
        do {
            opcio = menu();
            switch (opcio) {
                case 1:
                    mostrarButacas();
                    break;
                case 2:
                    mostrarButacasPersona();
                    break;
                case 3:
                    reservarButaca();
                    break;
                case 4:
                    anularReserva();
                    break;
                case 5:
                    anularReservaPersona();
                    break;
                case 0:
                    System.out.println("¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        } while (opcio != 0);
    }
    // Mostrará las opciones del menú principal al usuario, le pedirá el número de la opción escogida y lo devolverá.
    private int menu() {
        Scanner input = new Scanner(System.in);
        System.out.println("Menú principal:");
        System.out.println("1.- Mostrar todas las butacas reservadas.");
        System.out.println("2.- Mostrar las butacas reservadas por una persona.");
        System.out.println("3.- Reservar una butaca.");
        System.out.println("4.- Anular la reserva de una butaca.");
        System.out.println("5.- Anular todas las reservas de una persona.");
        System.out.println("0.- Salir.");
        System.out.print("Introduce una opción: ");
        return Integer.parseInt(input.nextLine());
    }



    // Mostrará todas las butacas reservadas.
    private void mostrarButacas() {
        ArrayList<Butaca> butacas = gestionButacas.getButacas();
        if (butacas.size() == 0) {
            System.out.println("No hay butacas reservadas.");
        } else {
            System.out.println("Butacas reservadas:");
            for (Butaca but : butacas) {
                System.out.println(but.toString());
            }
        }
    }

    // Pedirá el nombre de la persona que ha hecho la reserva y mostrará todas las butacas reservadas por esa persona.

    private void mostrarButacasPersona() {
        Scanner input = new Scanner(System.in);
        System.out.print("Introduce el nombre de la persona: ");
        String persona = input.nextLine().trim(); // se utiliza trim() para eliminar posibles espacios en blanco al inicio y final de la cadena
        if (persona.isEmpty()) { // se valida si la cadena está vacía
            System.out.println("Nombre de persona no válido.");
            return;
        }
        ArrayList<Butaca> butacas = gestionButacas.getButacas();
        boolean encontrada = false;
        for (Butaca but : butacas) {
            if (but.getPersona().equals(persona)) {
                System.out.println(but.toString());
                encontrada = true;
            }
        }
        if (!encontrada) {
            System.out.println("No se han encontrado butacas reservadas para la persona indicada.");
        }
    }

    // Pide al usuario un número de fila, un número de asiento y el nombre de la persona que hace la reserva,
    // y reserva la butaca correspondiente.
    private void reservarButaca() {
        Scanner input = new Scanner(System.in);
        int nombreFila;
        int numAsiento;
        String persona;
        try {
            nombreFila = introducirFila();
            numAsiento = introducirAsiento();
            persona = introducirPersona();
            Butaca butaca = new Butaca(nombreFila, numAsiento, persona);
            gestionButacas.anadirButaca(butaca);
            System.out.println("Butaca reservada correctamente.");
        } catch (ExcepcioFilaIncorrecta | ExcepcioSeientIncorrecte | ExcepcioNomPersonaIncorrecte e) {
            System.out.println(e.getMessage());
        } catch (ExcepcioButacaOcupada e) {
            System.out.println(e.getMessage());
        }
    }



    // Pide al usuario el número de filas y el número de asientos por fila,
    // y los guarda en los atributos correspondientes.
    private void pedirDatosIniciales() {
        Scanner input = new Scanner(System.in);
        System.out.print("Introduce el numero de filas del cine: ");
        numFilas= input.nextInt();
        System.out.print("Introduce el numero de asientos por fila: ");
        numAsientoPorFila = input.nextInt();
    }


    // Pide al usuario la fila y el asiento de una persona, y elimina  reserva
    private void anularReserva() {
        Scanner input = new Scanner(System.in);
        int numFila;
        int numAsiento;

        try {
            numFila = introducirFila();
            numAsiento = introducirAsiento();
        } catch (ExcepcioFilaIncorrecta | ExcepcioSeientIncorrecte e) {
            System.out.println(e.getMessage());
            return;
        }

        try {
            gestionButacas.eliminarButaca(numFila, numAsiento);
            System.out.println("Reserva de butaca anulada correctamente.");
        } catch (ExcepcioButacaLliure e) {
            System.out.println(e.getMessage());
        }
    }


    // Pide al usuario el nombre de una persona, y elimina todas las reservas de butacas de esa persona.

    private void anularReservaPersona() throws ExcepcioButacaLliure {
        Scanner input = new Scanner(System.in);
        System.out.print("Introduce el nombre de la persona: ");
        String persona = input.nextLine();
        ArrayList<Butaca> butacas = gestionButacas.getButacas();
        boolean eliminada = false;

        for (int i = 0; i < butacas.size(); i++) {
            Butaca butaca = butacas.get(i);
            if (butaca.getPersona().equals(persona)) {
                gestionButacas.eliminarButaca(butaca.getNumFila(), butaca.getNumAsiento());
                eliminada = true;
                i--; // Retroceder el índice después de eliminar una butaca
            }
        }

        if (eliminada) {
            System.out.println("Todas las reservas de la persona indicada han sido anuladas.");
        } else {
            System.out.println("No se han encontrado reservas para la persona indicada.");
        }
    }






    // Pide al usuario un número de fila y lo devuelve si es correcto. Si no, lanza una excepción personalizada ExcepcioFilaIncorrecta.
    private int introducirFila() throws ExcepcioFilaIncorrecta {
        Scanner input = new Scanner(System.in);
        System.out.print("Introduce el número de fila: ");
        int fila = input.nextInt();
        if (fila < 1 || fila > numFilas) {
            throw new ExcepcioFilaIncorrecta("El número de fila introducido no es válido.");
        }
        return fila;
    }

    // Pide al usuario un número de asiento y lo devuelve si es correcto. Si no, lanza una excepción personalizada ExcepcioSeientIncorrecte.
    private int introducirAsiento() throws ExcepcioSeientIncorrecte {
        Scanner input = new Scanner(System.in);
        System.out.print("Introduce el número de asiento: ");
        try {
            int numAsiento = input.nextInt();
            if (numAsiento < 1 || numAsiento > numAsientoPorFila) {
                throw new ExcepcioSeientIncorrecte("Número de asiento incorrecto.");
            }
            return numAsiento;
        } catch (InputMismatchException e) {
            throw new ExcepcioSeientIncorrecte("Formato de número de asiento incorrecto.");
        }
    }
    // Pide al usuario el nombre de una persona y lo devuelve si es correcto. Si no, lanza una excepción personalizada ExcepcioNomPersonaIncorrecte.
    private String introducirPersona() throws ExcepcioNomPersonaIncorrecte {
        Scanner input = new Scanner(System.in);
        System.out.print("Introduce el nombre de la persona que reserva la butaca: ");
        String persona = input.nextLine();
        if (persona.length() == 0) {
            throw new ExcepcioNomPersonaIncorrecte("El nombre de la persona no puede estar vacío.");
        }
        return persona;
    }





}







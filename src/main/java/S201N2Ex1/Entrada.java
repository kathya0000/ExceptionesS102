package S201N2Ex1;

import java.util.Scanner;

public class Entrada {

    private static Scanner sc = new Scanner(System.in);

    public static byte leerByte(String mensaje) {
        byte dato = 0;
        boolean error = true;
        do {
            try {
                System.out.print(mensaje);
                dato = sc.nextByte();
                error = false;
            } catch (Exception e) {
                System.out.println("Error de formato, introduce un byte válido.");
                sc.nextLine();
            }
        } while (error);
        return dato;
    }

    public static int leerInt(String mensaje) {
        int dato = 0;
        boolean error = true;
        do {
            try {
                System.out.print(mensaje);
                dato = sc.nextInt();
                error = false;
            } catch (Exception e) {
                System.out.println("Error de formato, introduce un entero válido.");
                sc.nextLine();
            }
        } while (error);
        return dato;
    }

    public static float leerFloat(String mensaje) {
        float dato = 0;
        boolean error = true;
        do {
            try {
                System.out.print(mensaje);
                dato = sc.nextFloat();
                error = false;
            } catch (Exception e) {
                System.out.println("Error de formato, introduce un float válido.");
                sc.nextLine();
            }
        } while (error);
        return dato;
    }

    public static double leerDouble(String mensaje) {
        double dato = 0;
        boolean error = true;
        do {
            try {
                System.out.print(mensaje);
                dato = sc.nextDouble();
                error = false;
            } catch (Exception e) {
                System.out.println("Error de formato, introduce un double válido.");
                sc.nextLine();
            }
        } while (error);
        return dato;
    }

    public static char leerChar(String mensaje) {
        char dato = '\0';
        boolean error = true;
        do {
            try {
                System.out.print(mensaje);
                dato = sc.next().charAt(0);
                error = false;
            } catch (Exception e) {
                System.out.println("Error de formato, introduce un caracter válido.");
                sc.nextLine();
            }
        } while (error);
        return dato;
    }

    public static String leerString(String mensaje) {
        String dato = "";
        boolean error = true;
        do {
            try {
                System.out.print(mensaje);
                dato = sc.nextLine();
                error = false;
            } catch (Exception e) {
                System.out.println("Error de formato, introduce una cadena válida.");
                sc.nextLine();
            }
        } while (error);
        return dato;
    }

    public static boolean leerSiNo(String mensaje) {
        boolean dato = false;
        boolean error = true;
        do {
            try {
                System.out.print(mensaje);
                String respuesta = sc.next();
                if (respuesta.equalsIgnoreCase("s")) {
                    dato = true;
                } else if (respuesta.equalsIgnoreCase("n")) {
                    dato = false;
                } else {
                    throw new Exception();
                }
                error = false;
            } catch (Exception e) {
                System.out.println("Error de formato, introduce 's' o 'n'.");
                sc.nextLine();
            }
        } while (error);
        return dato;
    }
}


import java.util.Scanner;

public class SaludoUsuario {
    public static void main(String[] args) {

        // Declaracion de Variables.
        var separador = "*".repeat(60);

        // Uso de scaner para insewrtar informacion
        Scanner sc = new Scanner(System.in);

        System.out.println(separador);
        System.out.println("Programa de saludo a usuario.");
        System.out.println(separador);
        System.out.print("Cual es tu nombre: ");
        String usuario = sc.nextLine();
        System.out.println(separador);
        System.out.println(separador);
        System.out.println("Hola "+ usuario +".");
        System.out.println("Bienvenido a programacion en Java");
        System.out.println(separador);
    }

}
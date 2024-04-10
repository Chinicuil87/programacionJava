import java.util.Scanner;

public class SaludoUsuario {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("***********************************");
        System.out.println("Programa de saludo a usuario.");
        System.out.print("Cual es tu nombre: ");
        String usuario = sc.nextLine();
        System.out.println("***********************************");
        System.out.println("***********************************");
        System.out.println("Hola "+ usuario +".");
        System.out.println("Bienvenido a programacion en java");
        System.out.println("***********************************");
    }

}
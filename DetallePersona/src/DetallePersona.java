import java.util.Scanner;

public class DetallePersona {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String nombre = "";
        String apellidoPaterno = "";
        String apellidoMaterno = "";
        int edad = 0;
        double altura = 0;
        double peso = 0;
        String pais = "";
        char estadoCivil = 0;
        String separador = "**************************************************";

        System.out.println(separador);
        System.out.println(            "Bienvenido Usuario");
        System.out.println("Ingresa la informacion solicitada.");
        System.out.print("Nombre: ");
        nombre = sc.nextLine();
        System.out.print("Apellido Paterno: ");
        apellidoPaterno = sc.nextLine();
        System.out.print("Apellido Materno: ");
        apellidoMaterno = sc.nextLine();
        System.out.print("Edad: ");
        edad = Integer.parseInt(sc.nextLine());
        System.out.print("Altura: ");
        altura = Double.parseDouble(sc.nextLine());
        System.out.print("Peso: ");
        peso = Double.parseDouble(sc.nextLine());
        System.out.print("Pais: ");
        pais = sc.nextLine();
        System.out.println("Estado civil (c - casado o s - soltero: ");
        estadoCivil = sc.nextLine().charAt(0);

        String mensaje = "Nombre:" + nombre + " " + apellidoPaterno + " " + apellidoMaterno +
                "\nEdad: "+ edad +
                "\nAltura: " + altura +
                "\nPeso: " + peso +
                "\nPais: " + pais +
                "\nEstado Civil (c= casado, s = soltero): " + estadoCivil;

        System.out.println(separador);
        System.out.println(mensaje);
        System.out.println(separador);


    }
}

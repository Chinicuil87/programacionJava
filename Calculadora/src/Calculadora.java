import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double primerNumero;
        double segundoNumero;
        double resultado;
        boolean estatus = true;
        String separador = "**************************************************";
        String menu = """
                 Menu Aplicacion

                1. Suma
                2. Resta
                3. Multiplicacion
                4. Division
                5. Salir
                      
               Selecciona una opcion:
                """;

        System.out.println(separador);
        System.out.println("Bienvenido a la Calculadora");
        System.out.println(separador);

        while (estatus) {

            System.out.println(menu);
            int seleccionOperacion = sc.nextInt();

            switch (seleccionOperacion) {
                case 1 -> {
                    // Suma
                    System.out.println(separador);
                    System.out.println("Operacion Suma.");
                    System.out.println(separador);
                    System.out.print("Inserta el primer numero: ");
                    primerNumero = sc.nextDouble();
                    System.out.print("Inserta el segundo numero: ");
                    segundoNumero = sc.nextDouble();
                    resultado = primerNumero + segundoNumero;
                    System.out.println(separador);
                    System.out.println("La suma de los numeros es :" + resultado);
                    System.out.println(separador);
                }
                case 2 -> {
                    // Resta
                    System.out.println(separador);
                    System.out.println("Operacion Resta.");
                    System.out.println(separador);
                    System.out.print("Inserta el primer numero: ");
                    primerNumero = sc.nextDouble();
                    System.out.print("Inserta el segundo numero: ");
                    segundoNumero = sc.nextDouble();
                    resultado = primerNumero - segundoNumero;
                    System.out.println(separador);
                    System.out.println("La resta de los numeros es :" + resultado);
                    System.out.println(separador);
                }
                case 3 -> {
                    // Multiplicacion
                    System.out.println(separador);
                    System.out.println("Operacion Multiplicacion.");
                    System.out.println(separador);
                    System.out.print("Inserta el primer numero: ");
                    primerNumero = sc.nextDouble();
                    System.out.print("Inserta el segundo numero: ");
                    segundoNumero = sc.nextDouble();
                    resultado = primerNumero * segundoNumero;
                    System.out.println(separador);
                    System.out.println("La multiplicacion de los numeros es :" + resultado);
                    System.out.println(separador);
                }
                case 4 -> {
                    // Division
                    System.out.println(separador);
                    System.out.println("Operacion Division.");
                    System.out.println(separador);
                    System.out.print("Inserta el primer numero: ");
                    primerNumero = sc.nextDouble();
                    System.out.print("Inserta el segundo numero: ");
                    segundoNumero = sc.nextDouble();
                    resultado = primerNumero / segundoNumero;
                    System.out.println(separador);
                    System.out.println("La division de los numeros es :" + resultado);
                    System.out.println(separador);
                }
                case 5 -> {
                    // Salir
                    System.out.println(separador);
                    System.out.println("++ Fin del programa, hazta luego ++");
                    System.out.println(separador);
                    estatus = false;
                }
                default -> {
                    // Opcion no valida
                    System.out.println(separador);
                    System.out.println("Opcion no valida " + seleccionOperacion);
                    System.out.println(separador);
                }

            }
        }

    }
}

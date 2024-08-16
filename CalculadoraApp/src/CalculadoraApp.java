import java.util.Scanner;
import java.util.Stack;

public class CalculadoraApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String separador = "--------------------------------------------------";

        boolean ejecutar = true;


        while (ejecutar) {

            // Mostrar el nombre de la aplicacion.

            System.out.println(separador);
            System.out.println("             APLICACION CALCULADORA");
            System.out.println(separador);

            // Muestra el menu de opciones.
            mostrarMenu();

            try {
                var seleccion = Integer.parseInt(sc.nextLine());

                // Validamos que el usuario ingreso una opcion valida.
                if (seleccion >= 1 && seleccion <= 4) {
                    ejecutarOperacion(seleccion, sc);
                } // fin if

                else if (seleccion == 5) { // salir
                    System.out.println(separador);
                    System.out.println("               Fin de la aplicacion");
                    System.out.println("                   Vuelva pronto");
                    System.out.println(separador);
                    break;
                }

                else {
                    System.out.println("Opcion no valida: " + seleccion);
                }
                System.out.println();

            } // fin try
            catch (Exception e){
                System.out.println("Ocurrio un error: " + e.getMessage());
            }// fin catch

        }// fin while

    }// fin main

    private static void mostrarMenu(){

        String separador = "--------------------------------------------------";

        System.out.println("""
                                           MENU
                        
                    1. Suma
                    2. Resta
                    3. Multiplicacion
                    4. Division
                    5. Salir
                    """);

        // Solicita al usuario escoja una opcion.

        System.out.println(separador);
        System.out.print("Seleccione la opcion deseada: ");
    }

    private static void ejecutarOperacion(int seleccion, Scanner sc){

        System.out.print("Ingresa el primer numero: ");
        var numero1 = Integer.parseInt(sc.nextLine());
        System.out.print("Ingresa el primer numero: ");
        var numero2 = Integer.parseInt(sc.nextLine());

        int resultado;

        String separador = "--------------------------------------------------";

        switch (seleccion) {
            case 1 -> { // suma
                resultado = numero1 + numero2;
                System.out.println(separador);
                System.out.println("La suma de los numeros es igual a: " + +resultado);
                System.out.println(separador);
            }
            case 2 -> { // resta
                resultado = numero1 - numero2;
                System.out.println(separador);
                System.out.println("La resta de los numeros es igual a: " + resultado);
                System.out.println(separador);
            }
            case 3 -> { // multiplicacion
                resultado = numero1 * numero2;
                System.out.println(separador);
                System.out.println("La multiplicacion de los numeros es igual a: " + resultado);
                System.out.println(separador);
            }
            case 4 -> { // division
                resultado = numero1 / numero2;
                System.out.println(separador);
                System.out.println("La division de los numero es igual a: " + resultado);
                System.out.println(separador);
            }
            default -> {
                System.out.println(separador);
                System.out.println("Opcion no valida: " + seleccion);
                System.out.println(separador);
            }
        } // fin switch
    }

} // fin class
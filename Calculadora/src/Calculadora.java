import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double primerNumero;
        double segundoNumero;
        double resultado;
        boolean estatus = true;
        String menu = """
                Selecciona la operacion a realizar.
                
                1. Suma
                2. Resta
                3. Multiplicacion
                4. Division
                5. Salir
                
                """;

        System.out.println("****************************************");
        System.out.println("Bienvenido a la Calculadora");
        System.out.println("****************************************");



        while (estatus){

            System.out.println(menu);
            int seleccionOperacion = sc.nextInt();

            switch (seleccionOperacion){
                case 1:
                    System.out.println("****************************************");
                    System.out.println("Operacion Suma.");
                    System.out.print("Inserta el primer numero: ");
                    primerNumero = sc.nextDouble();
                    System.out.print("Inserta el segundo numero: ");
                    segundoNumero = sc.nextDouble();
                    resultado = primerNumero + segundoNumero;
                    System.out.println("La suma de los numeros es :" + resultado);
                    System.out.println("****************************************");
                    break;
                case 2:
                    System.out.println("****************************************");
                    System.out.println("Operacion Resta.");
                    System.out.print("Inserta el primer numero: ");
                    primerNumero = sc.nextDouble();
                    System.out.print("Inserta el segundo numero: ");
                    segundoNumero = sc.nextDouble();
                    resultado = primerNumero - segundoNumero;
                    System.out.println("La resta de los numeros es :" + resultado);
                    System.out.println("****************************************");
                    break;
                case 3:
                    System.out.println("****************************************");
                    System.out.println("Operacion Multiplicacion.");
                    System.out.print("Inserta el primer numero: ");
                    primerNumero = sc.nextDouble();
                    System.out.print("Inserta el segundo numero: ");
                    segundoNumero = sc.nextDouble();
                    resultado = primerNumero * segundoNumero;
                    System.out.println("La multiplicacion de los numeros es :" + resultado);
                    System.out.println("****************************************");
                    break;
                case 4:
                    System.out.println("****************************************");
                    System.out.println("Operacion Division.");
                    System.out.print("Inserta el primer numero: ");
                    primerNumero = sc.nextDouble();
                    System.out.print("Inserta el segundo numero: ");
                    segundoNumero = sc.nextDouble();
                    resultado = primerNumero / segundoNumero;
                    System.out.println("La division de los numeros es :" + resultado);
                    System.out.println("****************************************");
                    break;
                case 5:
                    System.out.println("****************************************");
                    System.out.println("++ Fin del programa, hazta luego ++");
                    System.out.println("****************************************");
                    estatus = false;
            }
        }



    }
}

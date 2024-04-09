//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numeroSecreto = new Random().nextInt(100);
        int intentos = 5;

        System.out.println("**************************************************");
        System.out.println("ADIVINA EL NUMERO.");
        System.out.println("**************************************************");
        System.out.print("Inserta el nombre del jugador: ");
        String nombreJugador = sc.nextLine();

        String mensajeBienvenida = """
                Bienvenido %s, al juego de adivina el numero.
                
                Instrucciones del juego:
           
                1. Debes colocar un numero entre el 0 y el 100.
                2. Solo tienes 5 intentos para poder adivinar, de lo contrario perderas en juego.
                3. Reciviras pistas, donde te indicare si el numero es mayor o menor al que colocaste.
                Asi que mucha suerte y comenzamos.
                """.formatted(nombreJugador);

        String mensajeGanador = """
                *****************************************************
                Felicidades %s , has ganado el numero secreto era %d.
                *****************************************************
                """.formatted(nombreJugador, numeroSecreto);

        String mensajePerdedor = """
                ******************************************************
                Haz perdido el numero secrero es: %d
                ******************************************************
                """.formatted(numeroSecreto);

        System.out.println(mensajeBienvenida);

        while (intentos > 0){

            System.out.println("Intestos restantes " + intentos);
            --intentos;

            System.out.print("Coloca el numero: ");
            int numeroJugador = sc.nextInt();

            if (numeroJugador == numeroSecreto) {
                System.out.println(mensajeGanador);
                break;
            } else {
                if (numeroJugador>numeroSecreto){
                    System.out.println("El numero es menor.");
                }else {
                    System.out.println("El nunero es mayor.");
                }
        }
            if (intentos == 0){
                System.out.println(mensajePerdedor);
            }
        }
    }
}

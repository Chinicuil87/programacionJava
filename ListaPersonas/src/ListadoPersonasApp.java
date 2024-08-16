import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListadoPersonasApp {

    public static void main(String[] args) {

        Scanner consola = new Scanner(System.in);
        // Se define fuera del ciclo para evitar que se reinicie
        List<Persona> personas = new ArrayList<>();

        var ejecutar = true;

        while (ejecutar){
            mostrarMenu();
            try {
                ejecutar = ejecutarOperacion(consola, personas);
            } catch (Exception e){
                System.out.println("--------------------------------------------------");
                System.out.println("Ocurrio un error: "+ e.getMessage());
                System.out.println("--------------------------------------------------");
            }
            System.out.println();
        }
    }

    private static void mostrarMenu(){

        // Declaracion de variables

        String separador = "--------------------------------------------------";

        System.out.println(separador);
        System.out.println("        **** APP LISTADO DE PERSONAS ****");
        System.out.println(separador);
        System.out.print("""
                                  MENU DE OPCIONES
                                   
                1. Agregar
                2. Listar
                3. Salir
                
                """);

        System.out.println(separador);
        System.out.print("Elige una opcion: ");
    }

    private static boolean ejecutarOperacion(Scanner consola, List<Persona> personas){
        var opcion = Integer.parseInt(consola.nextLine());
        var ejecutar = true;
        String separador = "--------------------------------------------------";
        // Revisar opcion proporcionada
        switch (opcion){
            case 1 ->{ // Agregar persona a la lista
                System.out.print("Nombre: ");
                var nombre = consola.nextLine();
                System.out.print("Telefono: ");
                var tel = consola.nextLine();
                System.out.print("Correo: ");
                var email = consola.nextLine();

                var persona = new Persona(nombre, tel, email);
                personas.add(persona);
                System.out.println(separador);
                System.out.println("La lista tiene: "+ personas.size() + " elimentos");
                System.out.println(separador);
            }
            case 2 ->{ // Mostrar lista de personas
                System.out.println(separador);
                System.out.println("Listado de personas: ");
                System.out.println(separador);
                //personas.forEach(personas) -> System.out.println(persona);
                System.out.println(separador);
                personas.forEach(System.out::println);
                System.out.println(separador);
            }
            case 3 ->{ // Salir de aplicacion
                System.out.println(separador);
                System.out.println("                  Fin aplicacion");
                System.out.println(separador);
                ejecutar = false;
            }
            default -> System.out.println("Opcion invalida.");
        }
        return ejecutar;
    }
}// fin
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListadoPersonasApp {

    public static void main(String[] args) {

        Scanner consola = new Scanner(System.in);

        List<Persona> personas = new ArrayList<>();

        var salir = false;

        while (!salir){
            mostrarMenu();
            try {
                salir = ejecutarOperacion(consola, personas);
            } catch (Exception e){
                System.out.println("Ocurrio un error: "+ e.getMessage());
            }
            System.out.println();
        }
    }

    private static void mostrarMenu(){
        System.out.print("""
                **** Listado personas ****
                1. Agregar
                2. Listar
                3. Salir
                """);

        System.out.print("Elige una opcion: ");
    }

    private static boolean ejecutarOperacion(Scanner consola, List<Persona> personas){
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;

        switch (opcion){
            case 1 ->{
                System.out.print("Nombre: ");
                var nombre = consola.nextLine();
                System.out.print("Telefono: ");
                var tel = consola.nextLine();
                System.out.print("Correo: ");
                var email = consola.nextLine();

                var persona = new Persona(nombre, tel, email);
                personas.add(persona);
                System.out.println("La lista tiene: "+ personas.size() + " elimentos");
            }
            case 2 ->{
                System.out.println("Listado de personas: ");
                //personas.forEach(personas) -> System.out.println(persona);
                personas.forEach(System.out::println);
            }
            case 3 ->{
                System.out.println("Fin aplicacion");
                salir = true;
            }
            default -> System.out.println("Opcion invalida.");
        }
        return salir;
    }
}// fin
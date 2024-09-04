package zona_fit.presentacion;

import zona_fit.datos.ClienteDAO;
import zona_fit.datos.IClienteDAO;
import zona_fit.dominio.Cliente;

import java.util.Scanner;

public class ZonaFitApp {
    public static void main(String[] args) {

        var separador = "*".repeat(80);

        System.out.println(separador);
        zonaFitApp();
        System.out.println(separador);

    }

    private static void zonaFitApp(){
        var ejecucion = false;
        var cs = new Scanner(System.in);

        // Onjeto de la clase DAO
        IClienteDAO clienteDao = new ClienteDAO();

        while (!ejecucion){
            try {
                var opcion = menu(cs);
                ejecucion = ejecutarOpciones(cs, opcion, clienteDao);

            }catch (Exception e){
                System.out.println("Error al ejecutar opciones: " + e.getMessage());
            }

        }

    }

    private static int menu(Scanner cs){
        var separador = "*".repeat(80);
        var tituloApp = "*** Zona Fit ***";
        System.out.println(separador);
        System.out.println(" ".repeat((80-tituloApp.length())/2) + tituloApp);
        System.out.println(separador);
        System.out.println( """
                    Menu de Opciones
                    
                1. Mostrar lista de usuarios.
                2. Buscar usuario.
                3. Agregar usuario.
                4. Modificar usuario.
                5. Eliminar usuario.
                6. Salir del programa.
                """);
        System.out.println(separador);
        System.out.print("Elige la opcion deseada: ");
        var opcion = Integer.parseInt(cs.nextLine());
        return opcion;
    }

    private static boolean ejecutarOpciones(Scanner cs, int  opcion, IClienteDAO clienteDAO){
        var ejecucion = false;
        var separador = "*".repeat(80);
        switch (opcion){
            case 1 -> { // Lista de usuarios.
                System.out.println(separador);
                System.out.println("*** Lista de Usuarios ***");
                System.out.println(separador);
                var usuarios = clienteDAO.listarClientes();
                usuarios.forEach(System.out::println);
                break;
            }
            case 2 -> { // Buscar usuario por id
                System.out.println(separador);
                System.out.println("*** Buscar Usuario por ID ***");
                System.out.println(separador);
                System.out.print("Id buscado: ");
                int id = Integer.parseInt(cs.nextLine());
                var usuario1 = new Cliente(id);
                var encontrado =  clienteDAO.buscarClientePorId(usuario1);
                System.out.println(separador);
                if (encontrado)
                    System.out.println("Cliente encontrado: "  +  usuario1);
                else
                    System.out.println("Cliente no encontrado: " + usuario1.getId());

                System.out.println(separador);
                break;
            }
            case 3 -> { //Agregar Usuario
                System.out.println(separador);
                System.out.println("*** Agregar Usuario ***");
                System.out.println(separador);
                // Captura de datos
                System.out.print("Nombre del usuario: ");
                var nombre = cs.nextLine();
                System.out.print("Apellido del usuario: ");
                var apellido = cs.nextLine();
                System.out.print("Numero de membresia: ");
                var membresia = Integer.parseInt(cs.nextLine());

                var usuario = new Cliente(nombre, apellido, membresia);
                var agregado = clienteDAO.agregarCliente(usuario);
                if (agregado)
                    System.out.println("Usuario agregado: " + usuario);
                else
                    System.out.println("Usuario no agregado" + usuario);
                break;
            }
            case 4 ->{// Modificar Usuario
                System.out.println(separador);
                System.out.println("*** Modificar Usuario ***");
                System.out.println(separador);
                System.out.print("ID usuario: ");
                var id = Integer.parseInt(cs.nextLine());
                System.out.print("Nombre del usuario: ");
                var nombre = cs.nextLine();
                System.out.print("Apellido del usuario: ");
                var apellido = cs.nextLine();
                System.out.print("Numero de membresia: ");
                var membresia = Integer.parseInt(cs.nextLine());
                var usuario = new Cliente(id, nombre, apellido, membresia);
                var modificacion = clienteDAO.modificarCliente(usuario);
                if (modificacion)
                    System.out.println("Usuario modificado: " + modificacion);
                else
                    System.out.println("No se modifico usuario: " + modificacion);
                break;
            }
            case 5 ->{
                System.out.println(separador);
                System.out.println("*** Eliminar usuario ***");
                System.out.println(separador);
                System.out.print("ID usuario a eliminar: ");
                var id = Integer.parseInt(cs.nextLine());
                var clienteEliminar = new Cliente(2);
                var eliminado = clienteDAO.eliminarCLiente(clienteEliminar);
                if (eliminado)
                    System.out.println("Usuario eliminado:" + clienteEliminar);
                else
                    System.out.println("No se elimino usuario:" + clienteEliminar);
                break;
            }
            case 6->{
                System.out.println(separador);
                System.out.println("*** Finalizando Programa ***");
                System.out.println(separador);
                ejecucion = true;
                break;
            }
            default -> {
                System.out.println(separador);
                System.out.println("Opcion no valida: " + opcion);
                System.out.println(separador);
            }

        }
        return ejecucion;
    }
}

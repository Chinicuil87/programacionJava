package gm.zona_fit;

import gm.zona_fit.modelo.Usuario;
import gm.zona_fit.servicio.IUsuarioServicio;
import gm.zona_fit.servicio.UsuarioServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

//@SpringBootApplication
public class ZonaFitApplication implements CommandLineRunner {

	@Autowired
	private IUsuarioServicio usuarioServicio;

	private static final Logger logger = LoggerFactory.getLogger(ZonaFitApplication.class);

	String nl = System.lineSeparator();
	String separador = "*".repeat(80);
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		logger.info("Iniciando la Aplicacion");
		// Levanta fabrica de spring
		SpringApplication.run(ZonaFitApplication.class, args);
		logger.info("Aplicacion Finalizada!");
	}

	@Override
	public void run(String... args) throws Exception {
		zonaFitApp();
	}

	private void zonaFitApp(){

		var ejecucion = false;
		IUsuarioServicio usuarioServicio = new UsuarioServicio();

		while (!ejecucion){

			logger.info(nl);
			logger.info(separador);
			logger.info(nl+ "*** Aplicacion Zona Fit (GYM) ***"+ nl);
			logger.info(separador);

			var menu  =  mostrarmenu(sc);
			ejecucion = ejecutarOpciones(sc, menu);
			logger.info(nl);
		}

	}

	private int mostrarmenu(Scanner sc){
		logger.info(nl + separador + nl);
		logger.info("""
                    Menu de Opciones
                    
                1. Mostrar lista de usuarios.
                2. Buscar usuario.
                3. Agregar usuario.
                4. Modificar usuario.
                5. Eliminar usuario.
                6. Salir del programa.
                """);
		logger.info(separador + nl);
		logger.info("Elige una opcion: ");
		return Integer.parseInt(sc.nextLine());
	}
	private boolean ejecutarOpciones(Scanner sc, int menu){
		var ejecucion =false;
		switch (menu){
			case 1 -> {
				logger.info(nl + separador + nl);
				logger.info(" *** Mostrar lista de usuarios ***"  + nl);
				logger.info(separador + nl);
				List<Usuario> usuarios = usuarioServicio.listaUsusarios();
				usuarios.forEach(usuario -> logger.info(usuario.toString() +  nl));
				logger.info(separador);
				break;
			}
			case 2 -> {
				logger.info(nl + separador + nl);
				logger.info(" *** Buscar usuario po ID ***" + nl);
				logger.info(separador + nl);
				logger.info("ID buscado: ");
				var idUsuario = Integer.parseInt(sc.nextLine());
				Usuario usuario =usuarioServicio.buscarUsuario(idUsuario);
				if (usuario != null){
					logger.info("Usuario encontrado: "  + usuario);
					logger.info(nl + separador);
				} else {
					logger.info("Usuario NO encontrado con el ID: "  + idUsuario);
					logger.info(nl + separador);
				}
				break;
			}
			case 3 -> {
				logger.info(nl + separador + nl);
				logger.info(" *** Agregar usuario ***"  + nl);
				logger.info(separador + nl);
				logger.info("Nombre del usuario: ");
				var nombre = sc.nextLine();
				logger.info("Apellido del usuario: ");
				var apellido = sc.nextLine();
				logger.info("Numero de membresia del usuario: ");
				var membresia = Integer.parseInt(sc.nextLine());

				var usuario = new Usuario();
				usuario.setNombre(nombre);
				usuario.setApellido(apellido);
				usuario.setMembresia(membresia);
				usuarioServicio.guardarUsuario(usuario);
				logger.info("Usuario agregado: " + usuario);
				break;
			}
			case 4 -> {
				logger.info(nl + separador + nl);
				logger.info(" *** Modificar usuario ***"  + nl);
				logger.info(separador + nl);
				logger.info("ID del usuario a modificar:  ");
				var id = Integer.parseInt(sc.nextLine());
				Usuario usuario = usuarioServicio.buscarUsuario(id);
				if (usuario != null) {
					logger.info("Nombre: ");
					var nombre = sc.nextLine();
					logger.info("Apellido: ");
					var apellido = sc.nextLine();
					logger.info("Numero de membresia: ");
					var membresia = Integer.parseInt(sc.nextLine());


					usuario.setNombre(nombre);
					usuario.setApellido(apellido);
					usuario.setMembresia(membresia);
					usuarioServicio.guardarUsuario(usuario);
					logger.info(separador + nl);
					logger.info("Usuario modificado correctamente: " + usuario);
				}else {
					logger.info(separador + nl);
					logger.info("Usuario no encontrado:  " + id);
				}
				break;
			}
			case 5 -> {
				logger.info(nl + separador + nl);
				logger.info(" *** Eliminar usuario ***"  + nl);
				logger.info(separador + nl);
				logger.info("ID del usuario a eliminar:  ");
				var id = Integer.parseInt(sc.nextLine());
				Usuario usuario = usuarioServicio.buscarUsuario(id);
				if (usuario != null) {
					usuarioServicio.eliminarUsuario(usuario);
					logger.info("Usuario eliminado correctamente: " + usuario);
				} else {
					logger.info("Usuario no encontrado: " + id);
				}
				break;
			}
			case 6 -> {
				logger.info(separador + nl);
				logger.info(" --- Finalizando programa ---"  + nl);
				logger.info(separador + nl);
				ejecucion = true;
				break;
			}
			default -> {
				logger.info(nl + separador + nl);
				logger.info("Opcion no valida: " + menu);
				logger.info(nl + separador);
			}

		}
		return ejecucion;
	}
}

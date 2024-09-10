package gm.zona_fit;

import gm.zona_fit.servicio.IUsuarioServicio;
import gm.zona_fit.servicio.UsuarioServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ZonaFitApplication implements CommandLineRunner {

	@Autowired
	private IUsuarioServicio usuarioServicio;

	private static final Logger logger = LoggerFactory.getLogger(ZonaFitApplication.class);

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

		var separador = "*".repeat(80);
		var ejecucion = false;
		var sc = new Scanner(System.in);
		IUsuarioServicio usuarioServicio = new UsuarioServicio();

		logger.info(separador);
		logger.info("*** Aplicacion Zona Fit (GYM) ***");
		logger.info(separador);

	}
}

package servicio;

import dominio.Pelicula;

import java.io.*;

public class ServicioPeliculasArchivo implements IServicioPeliculas{

    private final String NOMBRE_ARCHIVO = "peliculas.txt";

    public  ServicioPeliculasArchivo(){
        var archivo = new File(NOMBRE_ARCHIVO);
        try{
            if (archivo.exists()){
                System.out.println("El archivo ya existe!");
            }
            else {
                var salida = new PrintWriter(new FileWriter(archivo));
                salida.close();
                System.out.println("Se a creado el arhivo.");
            }
        }catch (Exception e){
            System.out.println("Ocurrio un error al abrir archivo: " + e.getMessage());
        }
    }

    @Override
    public void listarPeliculas() {
        var archivo = new File(NOMBRE_ARCHIVO);
        try{
            System.out.println("Listado de Peliculas");
            var entrada = new BufferedReader(new FileReader(archivo));
            String linea;
            linea = entrada.readLine();
            while (linea != null){
                var pelicula = new Pelicula(linea);
                System.out.println(pelicula);
                linea = entrada.readLine();
            }
            entrada.close();
        } catch (Exception e){
            System.out.println("Ocurrio un error a leer el archivo: "+ e.getMessage());
        }
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {

    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {

    }
}

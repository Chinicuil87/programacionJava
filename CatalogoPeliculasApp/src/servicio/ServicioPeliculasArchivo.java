package servicio;

import dominio.Pelicula;

import java.io.*;

public class ServicioPeliculasArchivo implements IServicioPeliculas{

    private final String NOMBRE_ARCHIVO = "peliculas.txt";

    public  ServicioPeliculasArchivo(){
        var archivo = new File(NOMBRE_ARCHIVO);
        try{
            // Si ya existe el archivo no se vuerlve a crear.
            if (archivo.exists()){
                System.out.println("El archivo ya existe!");
            }
            else {
                // Si no existe el archivo se crea vacio-
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
        boolean anexar = false;
        var archivo = new File(NOMBRE_ARCHIVO);
        try{
            anexar = archivo.exists();
            var salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(pelicula);
            salida.close();
            System.out.println("Se agrego al archivo el nombre de la pelicula: " + pelicula);
        }catch (Exception  e){
            System.out.println("Ocurrio un error al agregar pelicula: "+ e.getMessage());
        }
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        var archivo = new File(NOMBRE_ARCHIVO);
        try{
            var entrada = new BufferedReader(new FileReader(archivo));
            String lineaTexto;
            lineaTexto = entrada.readLine();
            var indice= 1;
            var encontrada = false;
            var peliculaBuscar = pelicula.getNombre();
            while (lineaTexto != null){
                if(peliculaBuscar != null && peliculaBuscar.equalsIgnoreCase(lineaTexto)){
                    encontrada = true;
                    break;
                }
                lineaTexto = entrada.readLine();
                indice++;
            }
            if(encontrada)
                System.out.println("Pelicula"+ lineaTexto
                        +" encontrada - linea" + indice);
            else
                System.out.println("No se encontro la pelicula: "
                        + pelicula.getNombre());
            entrada.close();
        }
        catch (Exception e){
            System.out.println("Ocurrio un error al buscar el archivo: " + e.getMessage());
        }

    }
}

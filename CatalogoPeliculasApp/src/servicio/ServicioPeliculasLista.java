package servicio;

import dominio.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class ServicioPeliculasLista implements IServicioPeliculas {

    private final List<Pelicula> peliculas;
    public ServicioPeliculasLista(){
        this.peliculas = new ArrayList<>();
    }
    @Override
    public void listarPeliculas() {
        System.out.println("Listado de Peliculas...");
        peliculas.forEach(System.out::println);
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
        System.out.println("Se agrego la Pelicula: " + pelicula);
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        var indice = peliculas.indexOf(pelicula);
        if(indice == -1)
            System.out.println("No se encontro la pelicula: " +pelicula);
        else
            System.out.println("Pelicula encontrada en el indice: " + indice);
    }
}

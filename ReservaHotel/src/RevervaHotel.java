public class RevervaHotel {
    public static void main(String[] args) {
        // Se declatran e inicializan las variables.
        String nombre = "Cesar Lopez";
        int diasEstancia = 5;
        double tarifaDiaria = 195.50;
        boolean vistaMar =  true;
        String titulo = "Sistema de reservacion";
        String separador = "*".repeat(50);

        String dtReserva = "Nombre: " + nombre +
                "\nDias de Estadia: " + diasEstancia +
                "\nTarifa diaria: " + tarifaDiaria +
                "\nCuarto vista al mar: " + vistaMar;

        System.out.println(separador);
        System.out.println(" ".repeat((50-titulo.length())/2) + titulo);
        System.out.println(separador);
        System.out.println(dtReserva);
        System.out.println(separador);



    } // fin main
}// fin clase

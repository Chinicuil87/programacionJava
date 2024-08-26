public class Presentandome {

    public static void main(String[] args) {

        // Declaramos variables.
        String separador = "*".repeat(50);
        String nombre = "Cesar Lopez Orihuela";
        Integer edad = 36;
        String pais = "Mexico";
        String correo = "clopezorihuela@hotmail.com";
        String celular = "7227580505";

        String mensaje = "Nombre: " + nombre +
                "\nEdad: " + edad + " años" +
                "\nPais: " + pais +
                "\nCorreo: " + correo +
                "\nTelefono: " + celular;

        // Mostramos en pantalla el  mensaje.
        System.out.println(separador);
        System.out.println();
        System.out.println(mensaje);
        System.out.println();
        System.out.println(separador);

    } // main
} // clase

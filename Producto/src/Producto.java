public class Producto {
    public static void main(String[] args) {
        String separador = "*".repeat(50);

        // Delacarion de variables

        String nombreProducto = "Tablet HP";
        Float precio = 1200.50f;
        int cantidad = 18;
        boolean disponible = true;
        String titulo = "Tienda en Linea";

        String  mensaje = "Producto: " + nombreProducto +
                "\nPrecio: " + precio +
                "\nCantidad Disponible: " + cantidad +
                "\nDsiponibilidad:  "+  disponible;

        // Muestra en consola los datos.
        System.out.println(separador);
        System.out.println(" ".repeat((50-titulo.length())/2)+titulo);
        System.out.println(mensaje);
        System.out.println(separador);

        // Actualizazion de variables
        nombreProducto = "Tablet HP Surface";
        precio = 1000f;
        cantidad = 10;
        disponible = false;

        mensaje = "Producto: " + nombreProducto +
                "\nPrecio: " + precio +
                "\nCantidad Disponible: " + cantidad +
                "\nDsiponibilidad:  "+  disponible;

        // Muestra en consola los nuevos datos.
        System.out.println(separador);
        System.out.println(" ".repeat((50-titulo.length())/2)+titulo);
        System.out.println(mensaje);
        System.out.println(separador);

    }
}

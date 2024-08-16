package mundopc;

import mundopc.modelo.Computadora;
import mundopc.modelo.Monitor;
import mundopc.modelo.Raton;
import mundopc.modelo.Teclado;
import mundopc.servicio.Orden;

public class VentaComputadoras {
    public static void main(String[] args) {

        Raton ratonHp = new Raton("USB", "HP");
        Teclado tecladoHp = new Teclado("USB", "HP");
        Monitor monitorHp = new Monitor("HP",21.5);

        Computadora computadoraHp = new Computadora("Computadora HP",
                monitorHp, tecladoHp, ratonHp);


        Raton ratonDell = new Raton("USB", "DELL");
        Teclado tecladoDell = new Teclado("USB", "Dell");
        Monitor monitorDell = new Monitor("DELL",19);

        Computadora computadoraDell = new Computadora("Computadora DELL",
                monitorDell, tecladoDell, ratonDell);


        Orden orden1 = new Orden();
        orden1.agregarComputadora(computadoraDell);
        orden1.mostrarOrden();

        Orden  orden2 = new Orden();
        orden2.agregarComputadora(computadoraHp);
        orden2.mostrarOrden();
    }
}
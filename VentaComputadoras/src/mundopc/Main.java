package mundopc;

import mundopc.modelo.Monitor;
import mundopc.modelo.Raton;
import mundopc.modelo.Teclado;

public class Main {
    public static void main(String[] args) {

        Raton ratonHp = new Raton("USB", "HP");
        System.out.println(ratonHp);
        Teclado tecladoHp = new Teclado("USB", "HP");
        System.out.println(tecladoHp);
        Monitor monitorHp = new Monitor("HP",21.5);
        System.out.println(monitorHp);
    }
}
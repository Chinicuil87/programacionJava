package mundopc.modelo;

public class Monitor {
    private final int idMonitor;
    private String marca;
    private double tamanio;
    private static int contadorMonitores;

    private Monitor (){
        idMonitor = ++contadorMonitores;
    }

    public Monitor(String marca, double tamanio){
        this();
        this.marca = marca;
        this.tamanio = tamanio;
    }

    @Override
    public String toString() {
        return
                "\n Monitor{" +
                "\n idMonitor= " + idMonitor +
                "\n marca= " + marca + '\'' +
                "\n tamanio= " + tamanio +
                '}'+
                "\n--------------------------------------------------";
    }
}

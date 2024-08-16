package mundopc.modelo;

public class DispositivoEntrada {
    private String tipoDeEntrada;
    private String marca;

    // Constructor
    public DispositivoEntrada(String tipoDeEntrada, String marca){
        this.tipoDeEntrada = tipoDeEntrada;
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "--------------------------------------------------" +
                "\n DispositivoEntrada{" +
                "\n tipoDeEntrada=" + tipoDeEntrada +
                "\n marca=" + marca +
                '}' +
                "\n--------------------------------------------------";
    }
}

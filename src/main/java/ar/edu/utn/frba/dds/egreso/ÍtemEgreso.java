package ar.edu.utn.frba.dds.egreso;

public abstract class ÍtemEgreso {
    private final String descripción;
    private final int valor;

    public ÍtemEgreso(String descripción, int valor) {
        this.descripción = descripción;
        this.valor = valor;
    }

    public String getDescripción() {
        return descripción;
    }

    public int getValor() {
        return valor;
    }

    public abstract boolean generaRemito();
}

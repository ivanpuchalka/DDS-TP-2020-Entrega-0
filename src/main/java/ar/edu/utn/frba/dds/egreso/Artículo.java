package ar.edu.utn.frba.dds.egreso;

public class Artículo extends ÍtemEgreso {

    public Artículo(String descripción, int valor) {
        super(descripción, valor);
    }

    @Override
    public boolean generaRemito() {
        return true;
    }
}

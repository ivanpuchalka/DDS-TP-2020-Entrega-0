package ar.edu.utn.frba.dds.egreso;

public class Servicio extends ÍtemEgreso {

    public Servicio(String descripción, int valor) {
        super(descripción, valor);
    }

    @Override
    public boolean generaRemito() {
        return false;
    }
}

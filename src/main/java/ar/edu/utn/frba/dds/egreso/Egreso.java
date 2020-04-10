package ar.edu.utn.frba.dds.egreso;

import java.util.HashSet;
import java.util.Set;

public class Egreso {
    private final Set<ÍtemEgreso> ítems = new HashSet<>();
    private EstadoEgreso estado = EstadoEgreso.ABIERTO;

    public void agregarÍtem(ÍtemEgreso ítem) {
        estado.agregarÍtem(ítem, ítems);
    }

    public Set<ÍtemEgreso> ítems() {
        return new HashSet<>(ítems);
    }

    public void quitarÍtem(ÍtemEgreso ítem) {
        estado.quitarÍtem(ítem, ítems);
    }

    public int valorTotal() {
        return ítems.stream().mapToInt(ÍtemEgreso::getValor).reduce(0, Integer::sum);
    }

    public EstadoEgreso estado() {
        return estado;
    }

    void estado(EstadoEgreso estado) {
        this.estado = estado;
    }

    public void cerrar() {
        estado.cerrar(this);
    }

    public boolean generaRemito() {
        return ítems.stream().allMatch(ÍtemEgreso::generaRemito);
    }
}

package ar.edu.utn.frba.dds.egreso;

import ar.edu.utn.frba.dds.egreso.exception.EgresoCerradoException;

import java.util.Set;

public enum EstadoEgreso {
    ABIERTO {
        @Override
        void cerrar(Egreso egreso) {
            egreso.estado(CERRADO);
        }

        @Override
        void agregarÍtem(ÍtemEgreso ítem, Set<ÍtemEgreso> ítems) {
            ítems.add(ítem);
        }

        @Override
        void quitarÍtem(ÍtemEgreso ítem, Set<ÍtemEgreso> ítems) {
            ítems.remove(ítem);
        }


    }, CERRADO {
        @Override
        void cerrar(Egreso egreso) {
            throw new EgresoCerradoException();
        }

        @Override
        void agregarÍtem(ÍtemEgreso ítem, Set<ÍtemEgreso> ítems) {
            throw new EgresoCerradoException();
        }

        @Override
        void quitarÍtem(ÍtemEgreso ítem, Set<ÍtemEgreso> ítems) {
            throw new EgresoCerradoException();
        }
    };

    abstract void cerrar(Egreso egreso);

    abstract void agregarÍtem(ÍtemEgreso ítem, Set<ÍtemEgreso> ítems);

    abstract void quitarÍtem(ÍtemEgreso ítem, Set<ÍtemEgreso> ítems);
}

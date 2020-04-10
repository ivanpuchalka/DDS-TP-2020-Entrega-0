package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.egreso.*;
import ar.edu.utn.frba.dds.egreso.exception.EgresoCerradoException;
import org.junit.Test;

import static org.junit.Assert.*;

public class EgresoTest {
    @Test
    public void egresoConUnSoloÍtemDevuelveValorDelÍtemComoTotal() {
        Egreso egreso = new Egreso();
        ÍtemEgreso ítemEgreso = new Artículo("Ítem único", 2000);
        egreso.agregarÍtem(ítemEgreso);

        assertEquals(2000, egreso.valorTotal());
    }

    @Test
    public void egresoConVariosÍtemsDevuelveSumaDeValoresComoTotal() {
        Egreso egreso = new Egreso();
        ÍtemEgreso ítemA = new Artículo("Ítem A", 2000);
        ÍtemEgreso ítemB = new Artículo("Ítem B", 1000);
        ÍtemEgreso ítemC = new Artículo("Ítem C", 3000);
        egreso.agregarÍtem(ítemA);
        egreso.agregarÍtem(ítemB);
        egreso.agregarÍtem(ítemC);

        assertEquals(6000, egreso.valorTotal());
    }

    @Test
    public void egresoSinÍtemsDevuelveValorTotalCero() {
        Egreso egreso = new Egreso();

        assertEquals(0, egreso.valorTotal());
    }

    @Test
    public void egresoAbiertoSePuedeCerrar() {
        Egreso egreso = new Egreso();

        egreso.cerrar();

        assertEquals(EstadoEgreso.CERRADO, egreso.estado());
    }

    @Test(expected = EgresoCerradoException.class)
    public void egresoCerradoLanzaExcepciónAlCerrar() {
        Egreso egreso = new Egreso();
        egreso.cerrar();

        egreso.cerrar();
    }

    @Test
    public void agregarÍtemAEgresoAbiertoAgregaElÍtem() {
        Egreso egreso = new Egreso();
        ÍtemEgreso ítemEgreso = new Artículo("Ítem", 100);

        egreso.agregarÍtem(ítemEgreso);

        assertTrue(egreso.ítems().contains(ítemEgreso));
    }

    @Test(expected = EgresoCerradoException.class)
    public void agregarÍtemAEgresoCerradoLanzaExcepción() {
        Egreso egreso = new Egreso();
        ÍtemEgreso ítemEgreso = new Artículo("Ítem", 100);
        egreso.cerrar();

        egreso.agregarÍtem(ítemEgreso);
    }

    @Test
    public void quitarÍtemDeEgresoAbiertoQuitaElÍtem() {
        Egreso egreso = new Egreso();
        ÍtemEgreso ítemEgreso = new Artículo("Ítem", 100);
        egreso.agregarÍtem(ítemEgreso);

        egreso.quitarÍtem(ítemEgreso);

        assertFalse(egreso.ítems().contains(ítemEgreso));
    }

    @Test(expected = EgresoCerradoException.class)
    public void quitarÍtemDeEgresoCerradoLanzaExcepción() {
        Egreso egreso = new Egreso();
        ÍtemEgreso ítemEgreso = new Artículo("Ítem", 100);
        egreso.agregarÍtem(ítemEgreso);
        egreso.cerrar();

        egreso.quitarÍtem(ítemEgreso);
    }

    @Test
    public void egresoGeneraRemitoCuandoTodosSusÍtemsSonArtículos() {
        Egreso egreso = new Egreso();
        Artículo artículoA = new Artículo("Artículo A", 100);
        Artículo artículoB = new Artículo("Artículo B", 100);
        egreso.agregarÍtem(artículoA);
        egreso.agregarÍtem(artículoB);

        assertTrue(egreso.generaRemito());
    }

    @Test
    public void egresoNoGeneraRemitoTieneAlgúnÍtemServicio() {
        Egreso egreso = new Egreso();
        Artículo artículo = new Artículo("Artículo", 100);
        Servicio servicio = new Servicio("Servicio", 100);
        egreso.agregarÍtem(artículo);
        egreso.agregarÍtem(servicio);

        assertFalse(egreso.generaRemito());
    }
}

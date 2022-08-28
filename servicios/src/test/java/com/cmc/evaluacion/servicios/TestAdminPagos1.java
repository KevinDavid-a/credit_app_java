package com.cmc.evaluacion.servicios;

import com.cmc.evaluacion.commons.Utilitario;
import com.cmc.evaluacion.entidades.Cuota;
import com.cmc.evaluacion.entidades.Prestamo;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestAdminPagos1 {

    @Test
    public void pagoPrimeraCuota(){
        Prestamo prestamo = new Prestamo(5000, 12, 15);
        CalculadoraAmortizacion.generarTabla(prestamo, TipoAmortizacion.FRANCESA);
        for (Cuota cuota : prestamo.getCuotas()) {
            cuota.setInteres(Utilitario.round(cuota.getInteres()));
            cuota.setCapitalInicio(Utilitario.round(cuota.getCapitalInicio()));
            cuota.setCouta(Utilitario.round(cuota.getCouta()));
            cuota.setAbonoCapital(Utilitario.round(cuota.getAbonoCapital()));
            cuota.setSaldo(Utilitario.round(cuota.getSaldo()));
            cuota.setPendiente(Utilitario.round(cuota.getPendiente()));
        }
        AdminPagos.pagar("1", 360.62, prestamo);
        CalculadoraAmortizacion.mostrarTable(prestamo);

        Cuota cuota = prestamo.getCuotas()[0];
        assertTrue(cuota.isPagado());
        assertEquals(0, cuota.getPendiente(), 0);


    }

}

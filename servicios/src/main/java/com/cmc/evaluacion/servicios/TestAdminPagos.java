package com.cmc.evaluacion.servicios;

import com.cmc.evaluacion.commons.Utilitario;
import com.cmc.evaluacion.entidades.Cuota;
import com.cmc.evaluacion.entidades.Prestamo;

public class TestAdminPagos {
    public static void main(String[] args) {
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

        AdminPagos.pagar("1", 1000, prestamo);

        CalculadoraAmortizacion.mostrarTable(prestamo);



    }
}

package com.cmc.evaluacion.servicios;

import com.cmc.evaluacion.entidades.Prestamo;

public class TestCalculadora1 {
    public static void main(String[] args) {
        Prestamo prestamo = new Prestamo(500000, 12, 15);
        CalculadoraAmortizacion.generarTabla(prestamo, TipoAmortizacion.FRANCESA);
        CalculadoraAmortizacion.mostrarTable2(prestamo);
    }
}

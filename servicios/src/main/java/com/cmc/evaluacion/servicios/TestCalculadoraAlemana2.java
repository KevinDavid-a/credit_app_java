package com.cmc.evaluacion.servicios;

import com.cmc.evaluacion.entidades.Prestamo;

public class TestCalculadoraAlemana2 {
    public static void main(String[] args) {
        Prestamo prestamo = new Prestamo(50000, 24, 12);
        CalculadoraAmortizacion.generarTabla(prestamo, TipoAmortizacion.ALEMANA);
        CalculadoraAmortizacion.mostrarTable(prestamo);
    }
}

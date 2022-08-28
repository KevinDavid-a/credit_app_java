package com.cmc.evaluacion.entidades;

public class TestPrint {
    public static void main(String[] args) {
        Cuota cuota = new Cuota(1);
        cuota.setCouta(444.24);
        cuota.setCapitalInicio(5000);
        cuota.setInteres(50);
        cuota.setAbonoCapital(394.24134);
        cuota.setSaldo(4605.76143);
        System.out.println(cuota);
    }
}

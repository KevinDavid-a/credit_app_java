package com.cmc.evaluacion.servicios;

import com.cmc.evaluacion.entidades.Cuota;
import com.cmc.evaluacion.entidades.Prestamo;

public class CalculadoraAmortizacion {

    public static double calcularCuota(Prestamo prestamo) {
        double interes = prestamo.getInteres() / 100 / 12;
        double numerator = prestamo.getMonto() * (interes);
        double denominator = 1 - Math.pow((1 + interes), -prestamo.getPlazo());
        return  numerator / denominator;
    }
    public static void generarTabla(Prestamo prestamo, String tipoAmortizacion) {
        if (tipoAmortizacion.equals("FR")){
            //Frances
            double cuota = calcularCuota(prestamo);
            for (int i = 0; i < prestamo.getPlazo(); i++) {
                prestamo.getCuotas()[i] = new Cuota(i + 1);
                prestamo.getCuotas()[i].setCouta(cuota);
                double capitalInicio = i == 0 ? prestamo.getMonto() : prestamo.getCuotas()[i-1].getSaldo();
                prestamo.getCuotas()[i].setCapitalInicio(capitalInicio);
                double interestMonth = capitalInicio * (prestamo.getInteres() / 100 / 12);
                prestamo.getCuotas()[i].setInteres(interestMonth);
                double abonoCapital = prestamo.getCuotas()[i].getCouta() - interestMonth;
                prestamo.getCuotas()[i].setAbonoCapital(abonoCapital);
                double saldoFinal = capitalInicio - abonoCapital;
                prestamo.getCuotas()[i].setSaldo(saldoFinal);
                prestamo.getCuotas()[i].setPendiente(cuota);
            }
        }else{
            // Aleman
            double interes = prestamo.getInteres() / 100 / prestamo.getPlazo();
            double capital = prestamo.getMonto() / prestamo.getPlazo();
            for (int i = 0; i < prestamo.getPlazo(); i++) {
                prestamo.getCuotas()[i] = new Cuota(i + 1);
                prestamo.getCuotas()[i].setAbonoCapital(capital);
                double capitalInicio = i == 0 ? prestamo.getMonto() : prestamo.getCuotas()[i-1].getSaldo();
                prestamo.getCuotas()[i].setCapitalInicio(capitalInicio);
                prestamo.getCuotas()[i].setInteres(capitalInicio * interes);
                double cuota = prestamo.getCuotas()[i].getAbonoCapital() + prestamo.getCuotas()[i].getInteres();
                prestamo.getCuotas()[i].setCouta(cuota);
                prestamo.getCuotas()[i].setSaldo(capitalInicio - prestamo.getCuotas()[i].getAbonoCapital());
                prestamo.getCuotas()[i].setPendiente(cuota);
            }
        }


    }

    public static void mostrarTable(Prestamo prestamo){
        for (int i = 0; i < prestamo.getCuotas().length; i++) {
            System.out.println(prestamo.getCuotas()[i]);
        }
    }


    public static void mostrarTable2(Prestamo prestamo){
        for (int i = 0; i < prestamo.getCuotas().length; i++) {
            System.out.println(prestamo.getCuotas()[i].toString2());
        }
    }
}

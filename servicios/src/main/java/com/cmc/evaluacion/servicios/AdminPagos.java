package com.cmc.evaluacion.servicios;


import com.cmc.evaluacion.entidades.Cuota;
import com.cmc.evaluacion.entidades.Prestamo;

public class AdminPagos {

    public static void pagar(String codigo, double monto, Prestamo prestamo){

        for (Cuota cuota : prestamo.getCuotas()) {
            double toPay = cuota.getCouta() - monto;
            if (toPay >= 0) {
                cuota.setPagado(toPay == 0);
                cuota.setPendiente(toPay);
                break;
            }else{
                cuota.setPendiente(0);
                cuota.setPagado(true);
                monto = Math.abs(toPay);
            }


        }
    }
}

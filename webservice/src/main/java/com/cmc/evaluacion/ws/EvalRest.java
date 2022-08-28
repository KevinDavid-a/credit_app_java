package com.cmc.evaluacion.ws;

import com.cmc.evaluacion.commons.Utilitario;
import com.cmc.evaluacion.entidades.Cuota;
import com.cmc.evaluacion.entidades.Prestamo;
import com.cmc.evaluacion.servicios.CalculadoraAmortizacion;
import com.cmc.evaluacion.ws.models.PrestamoDto;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/eval")
public class EvalRest {

    @Path("/cuotas")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Cuota[] simularPrestamo(PrestamoDto prestamoDto) {
        Prestamo prestamo = new Prestamo(prestamoDto.getMonto(), prestamoDto.getInteresAnual(), prestamoDto.getPlazo());
        CalculadoraAmortizacion.generarTabla(prestamo, prestamoDto.getTipo());
        //Round to two decimals cuotas
        for (Cuota cuota : prestamo.getCuotas()) {
          cuota.setCouta(Utilitario.round(cuota.getCouta()));
          cuota.setInteres(Utilitario.round(cuota.getInteres()));
          cuota.setCapitalInicio(Utilitario.round(cuota.getCapitalInicio()));
          cuota.setAbonoCapital(Utilitario.round(cuota.getAbonoCapital()));
          cuota.setSaldo(Utilitario.round(cuota.getSaldo()));
        }
        return prestamo.getCuotas();
    }

    @Path("/test")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String test(){
        return "Hello World";
    }

}

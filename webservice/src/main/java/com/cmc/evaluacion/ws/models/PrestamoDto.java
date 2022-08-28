package com.cmc.evaluacion.ws.models;

public class PrestamoDto {
    public double monto;
    public int plazo;
    public String tipo;
    public double interesAnual;

    public PrestamoDto() {
    }

    public PrestamoDto(double monto, int plazo, String tipo, double interesAnual) {
        this.monto = monto;
        this.plazo = plazo;
        this.tipo = tipo;
        this.interesAnual = interesAnual;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getInteresAnual() {
        return interesAnual;
    }

    public void setInteresAnual(double interesAnual) {
        this.interesAnual = interesAnual;
    }
}

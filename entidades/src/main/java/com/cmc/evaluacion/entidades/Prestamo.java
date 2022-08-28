package com.cmc.evaluacion.entidades;

public class Prestamo {

    private double monto;
    private double interes;
    private int plazo;

    private String codigo;

    private final Cuota[] cuotas;

    public Prestamo(double monto, double interes, int plazo) {
        this.monto = monto;
        this.interes = interes;
        this.plazo = plazo;
        this.cuotas = new Cuota[plazo];
    }

    public Prestamo(double monto, double interes, int plazo, String codigo) {
        this.monto = monto;
        this.interes = interes;
        this.plazo = plazo;
        this.codigo = codigo;
        this.cuotas = new Cuota[plazo];
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public Cuota[] getCuotas() {
        return cuotas;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}


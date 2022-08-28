package com.cmc.evaluacion.entidades;

import com.cmc.evaluacion.commons.Utilitario;

public class Cuota {

    private int numero;
    private double couta;

    private double capitalInicio;
    private double interes;
    private double abonoCapital;
    private double saldo;

    private boolean pagado;

    private double pendiente;

    public Cuota(int numero) {
        this.numero = numero;
        this.pagado = false;

    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getCouta() {
        return couta;
    }

    public void setCouta(double couta) {
        this.couta = couta;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public double getAbonoCapital() {
        return abonoCapital;
    }

    public void setAbonoCapital(double abonoCapital) {
        this.abonoCapital = abonoCapital;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getCapitalInicio() {
        return capitalInicio;
    }

    public void setCapitalInicio(double capitalInicio) {
        this.capitalInicio = capitalInicio;
    }

    public boolean isPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    public double getPendiente() {
        return pendiente;
    }

    public void setPendiente(double pendiente) {
        this.pendiente = pendiente;
    }

    @Override
    public String toString() {
        return numero + " | "
                + Utilitario.round(couta)
                + " | " + Utilitario.round(capitalInicio)
                + " | " + Utilitario.round(interes)
                + " | " + Utilitario.round(abonoCapital)
                + " | " + Utilitario.round(saldo)
                + " | " + pagado
                + " | " + Utilitario.round(pendiente);
    }

    public String toString2()
    {
        return numero + " | "
                + (couta)
                + " | " + (capitalInicio)
                + " | " + (interes)
                + " | " + (abonoCapital)
                + " | " + (saldo)
                + " | " + pagado
                + " | " + (pendiente);
    }
}

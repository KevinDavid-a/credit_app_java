package com.cmc.evaluacion.servicios;

import com.cmc.evaluacion.exceptions.DuplicatedException;
import com.cmc.evaluacion.entidades.Cliente;
import com.cmc.evaluacion.entidades.Prestamo;
import com.cmc.evaluacion.exceptions.NotFoundException;

import java.util.ArrayList;
import java.util.HashMap;


public class Banco {


    private HashMap<String, ArrayList<Prestamo>> prestamos;
    private ArrayList<Cliente> clientes;

    public Banco() {
        this.prestamos = new HashMap<>();
        this.clientes = new ArrayList<>();
    }

    public Cliente buscarCliente(String cedula) {
        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equals(cedula)) {
                return cliente;
            }
        }
        return null;
    }

    public void asignarPrestamo(String cedula, Prestamo prestamo) throws NotFoundException {
        if (buscarCliente(cedula) == null) {
            throw new NotFoundException("no es cliente del banco");
        }
        CalculadoraAmortizacion.generarTabla(prestamo, TipoAmortizacion.FRANCESA);
        if (prestamos.containsKey(cedula)) {
            prestamos.get(cedula).add(prestamo);
        } else {
            ArrayList<Prestamo> prestamos = new ArrayList<>();
            prestamos.add(prestamo);
            this.prestamos.put(cedula, prestamos);
        }
    }

    public ArrayList<Prestamo> buscarPrestamos(String cedula) {
        return prestamos.get(cedula);
    }

    public void registrarCliente(Cliente c) throws DuplicatedException {
        if (buscarCliente(c.getCedula()) != null) {
            throw new DuplicatedException("el cliente ya existe");
        }
        this.clientes.add(c);
    }

    public HashMap<String, ArrayList<Prestamo>> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(HashMap<String, ArrayList<Prestamo>> prestamos) {
        this.prestamos = prestamos;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
}

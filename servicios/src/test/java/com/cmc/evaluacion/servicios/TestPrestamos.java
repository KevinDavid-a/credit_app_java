package com.cmc.evaluacion.servicios;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import com.cmc.evaluacion.exceptions.DuplicatedException;
import com.cmc.evaluacion.exceptions.NotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import com.cmc.evaluacion.entidades.Cliente;
import com.cmc.evaluacion.entidades.Prestamo;


@SuppressWarnings("ALL")
public class TestPrestamos {
	private static Logger logger = LogManager.getLogger(TestPrestamos.class);



	@Test
	public void testClienteNoExiste() {
		Banco b=new Banco();
		try {
			b.registrarCliente(new Cliente("1714616123", "Camilo", "Cuesta"));
			b.registrarCliente(new Cliente("0514616123", "Ramiro", "Cuesta"));
			b.asignarPrestamo("12334324", new Prestamo(1000,12, 18));
		} catch (DuplicatedException e) {
			logger.error("El cliente no existe", e.getMessage());
			e.printStackTrace();
		}catch(NotFoundException e){
			logger.error("El cliente no existe", e.getMessage());
			e.printStackTrace();
			assertEquals("no es cliente del banco", e.getMessage());
		}
	}
	
	@Test
	public void testVariosPrestamos() {
		Banco b=new Banco();
		try {
			b.registrarCliente(new Cliente("1714616123", "Camilo", "Cuesta"));
			b.registrarCliente(new Cliente("0514616123", "Ramiro", "Cuesta"));
			b.asignarPrestamo("0514616123", new Prestamo(1000,12, 18));
			b.asignarPrestamo("0514616123", new Prestamo(5000,15, 24));
			b.asignarPrestamo("1714616123", new Prestamo(3000,15, 24));
		} catch (DuplicatedException e) {
			e.printStackTrace();
		}
		catch(NotFoundException e){
			e.printStackTrace();
		}
		ArrayList<Prestamo> prestamos=b.buscarPrestamos("0514616123");
		assertEquals(2,prestamos.size());
	}
	
	@SuppressWarnings("SimplifiableAssertion")
	@Test
	public void testNoTienePrestamos() {
		Banco b=new Banco();
		try {
			b.registrarCliente(new Cliente("1714616123", "Camilo", "Cuesta"));
			b.registrarCliente(new Cliente("0514616123", "Ramiro", "Cuesta"));
			b.asignarPrestamo("0514616123", new Prestamo(1000,12, 18));
			b.asignarPrestamo("0514616123", new Prestamo(5000,15, 24));
			b.asignarPrestamo("1714616123", new Prestamo(3000,15, 24));
		} catch (DuplicatedException e) {
			e.printStackTrace();
		}catch(NotFoundException e){
			e.printStackTrace();
		}
		ArrayList<Prestamo> prestamos=b.buscarPrestamos("123");
		assertEquals(null,prestamos);
	}
	
	@Test
	public void testValoresPrestamos() {
		Banco b=new Banco();
		try {
			b.registrarCliente(new Cliente("1714616123", "Camilo", "Cuesta"));
			b.registrarCliente(new Cliente("0514616123", "Ramiro", "Cuesta"));
			b.asignarPrestamo("0514616123", new Prestamo(1000,12, 18));
			b.asignarPrestamo("0514616123", new Prestamo(5000,15, 24));
			b.asignarPrestamo("1714616123", new Prestamo(3000,15, 24));
		} catch (DuplicatedException e) {
			e.printStackTrace();
		}catch(NotFoundException e){
			e.printStackTrace();
		}
		ArrayList<Prestamo> prestamos=b.buscarPrestamos("0514616123");
		assertEquals(2,prestamos.size());
		assertEquals(1000,prestamos.get(0).getCuotas()[0].getCapitalInicio(),0.01);
		assertEquals(0,prestamos.get(1).getCuotas()[23].getSaldo(),0.01);
	}
}

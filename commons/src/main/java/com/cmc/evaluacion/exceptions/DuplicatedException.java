package com.cmc.evaluacion.exceptions;

public class DuplicatedException extends Exception {
    private static final long serialVersionUID = 1L;

	public DuplicatedException(String message) {
        super(message);
    }
}

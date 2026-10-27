package edu.altair.crm.exceptions;

public class FaltaNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

	public FaltaNotFoundException(Long idFalta) {
        super("No se encontró la falta con el ID: " + idFalta);
    }
}

package com.grupo01.lucatinder.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProfileNotFoundException extends RuntimeException {
	
	public ProfileNotFoundException() {
		super("Lo sentimos, este usuario no existe. Prueba de nuevo.");
	}

}

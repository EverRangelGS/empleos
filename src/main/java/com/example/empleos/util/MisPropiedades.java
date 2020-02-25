package com.example.empleos.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MisPropiedades {
	
	@Value("${empleosapp.ruta.imagenes}")
	private String rutaImagenes;

	
	public String getRutaImagenes() {
		return rutaImagenes;
	}

	public void setRutaImagenes(String rutaImagenes) {
		this.rutaImagenes = rutaImagenes;
	}
	
}

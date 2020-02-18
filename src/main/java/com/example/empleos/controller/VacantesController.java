package com.example.empleos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/vacantes")
public class VacantesController {
	
	@GetMapping("/delete")
	public String eliminar(@RequestParam("id") int idVacante, Model model) {
		System.out.println("Borrando vacante con id: " + idVacante);	
		model.addAttribute("idVacante",idVacante);
		return "mensaje";
	}

	@GetMapping("/view/{id}")
	public String verDetalleq(@PathVariable("id") int idVacante, Model model) {
		System.out.println("IdVacante: "+idVacante);
		model.addAttribute("idVacante",idVacante);
		
		//TODO - Buscar los detalles en la base de datos
		
		return "vacantes/detalle";
	}
	
	
}

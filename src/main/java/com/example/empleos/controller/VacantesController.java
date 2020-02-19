package com.example.empleos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.empleos.model.Vacante;
import com.example.empleos.service.IVacantesService;

@Controller
@RequestMapping(value="/vacantes")
public class VacantesController {
	
	@Autowired
	@Qualifier("VacantesServImpl")
	private IVacantesService serviceVacantes;
	
	
	@GetMapping("/delete")
	public String eliminar(@RequestParam("id") int idVacante, Model model) {
		System.out.println("Borrando vacante con id: " + idVacante);	
		model.addAttribute("idVacante",idVacante);
		return "mensaje";
	}

	@GetMapping("/view/{id}")
	public String verDetalleq(@PathVariable("id") int idVacante, Model model) {
		
		Vacante vacante = serviceVacantes.buscarPorId(idVacante);
		
		System.out.println("Vacante: "+ vacante);
		model.addAttribute("vacante",vacante);
		
		//TODO - Buscar los detalles en la base de datos
		return "detalle";
	}
	
	
}

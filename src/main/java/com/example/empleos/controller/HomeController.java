package com.example.empleos.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.empleos.model.Vacante;
import com.example.empleos.service.IVacantesService;

/**
 * Agregando Devtools al realizar algún cambio se levantanuevamente la aplicación en el servidor 
 * @author efloresr
 *
 */

@Controller  //Ctr+shift+O se agregan las librerias en automático 
public class HomeController {
	
	
	@Autowired
	@Qualifier("VacantesServImpl")
	private IVacantesService serviceVacantes;
	
	
	@GetMapping("/tabla")
	public String mostrarTabla(Model model) {
		List<Vacante> lista = serviceVacantes.buscarTodas();
		model.addAttribute("vacantes", lista);
		return "tabla";
	}
	
	
	@GetMapping("/detalle")
	public String mostrarDetalle(Model model) {
		Vacante vacante = new Vacante();
		vacante.setNombre("Ingeniero de comunicaciones");
		vacante.setDescripcion("Se solicita ingeniero para dar soporte a internet");
		vacante.setFecha(new Date());
		vacante.setSalario(9700.0);
		//System.out.println(vacante.toString());
		
		model.addAttribute("vacante", vacante);		
		return "detalle";
	}
	
	
	@GetMapping("/listado")
	public String mostrarListado(Model model) {
		List<String> lista = new LinkedList<String>();
		lista.add("Ingeniero de Sistemas");
		lista.add("Auxiliar de Contabilidad");
		lista.add("Vendedor");
		lista.add("Arquitecto");
		
		model.addAttribute("empleos", lista);
		return "listado";
	}
	
	
	@GetMapping("/")
	public String mostrarHome(Model model) {
		List<Vacante> lista = serviceVacantes.buscarTodas();
		model.addAttribute("vacantes", lista);
		return "home";
	}
	
}

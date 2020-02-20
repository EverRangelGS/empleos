package com.example.empleos.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Vacante> lista = serviceVacantes.buscarTodas();
		model.addAttribute("vacantes", lista);
		return"vacantes/listVacantes";
	}
	
	@GetMapping("/create")
	public String crear() {
		return "vacantes/formVacante";
	}
	
	//Con @RequestBody se realiza el DataBinding
	@PostMapping("/save")
	public String guardar(Vacante vacante, Model model) { 
		serviceVacantes.guardar(vacante);
		System.out.println("Vacante: "+vacante);
		//model.addAttribute("vacante", vacante);
		return "vacantes/listVacantes";
	}
	
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
	
	
	//Para realizar el Data Binding es necesario indicar con @InitBinder con que formato vendra la fecha a guardar
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false)); //Con testo aseguramos que cuando se manejen datos de ipo Date lo maneje con el formato ("dd-MM-yyyy")
	}
	
}

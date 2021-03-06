package com.example.empleos.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.empleos.model.Vacante;

//Con esta anotacion Spring automaticamente creará una instancia de esta clase y la depositara en el contenedor de beans lista para ser usada
@Service("VacantesServImpl")
public class VacantesServiceImpl implements IVacantesService {
	
	private List<Vacante> lista = null;
	
	
	//El constructor se ejecuta solo una vez que se crea una instancia por lo cual solo tendremos una instancia tmb de la lista
	public VacantesServiceImpl() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		lista = new LinkedList<Vacante>();
		
		try {
			Vacante v1 = new Vacante();
			v1.setId(1);
			v1.setNombre("Ingeniero Civil");
			v1.setDescripcion("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed quis aliquet dui. ");
			v1.setFecha(sdf.parse("08-02-2020"));
			v1.setSalario(8500.0);
			v1.setDestacado(1);
			v1.setImagen("logo1.png");
			v1.setEstatus("Creada");
			
			Vacante v2 = new Vacante();
			v2.setId(2);
			v2.setNombre("Ingeniero Mecatronico");
			v2.setDescripcion("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed quis aliquet dui. ");
			v2.setFecha(sdf.parse("09-02-2020"));
			v2.setSalario(10500.0);
			v2.setDestacado(0);
			v2.setImagen("logo2.png");
			v2.setEstatus("Aprobada");
			
			Vacante v3 = new Vacante();
			v3.setId(3);
			v3.setNombre("Ingeniero Electronico");
			v3.setDescripcion("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed quis aliquet dui. ");
			v3.setFecha(sdf.parse("10-02-2020"));
			v3.setSalario(7000.0);
			v3.setDestacado(0);
			v3.setImagen("logo3.png");
			v3.setEstatus("Eliminada");
			
			Vacante v4 = new Vacante();
			v4.setId(4);
			v4.setNombre("Ingeniero Industrial");
			v4.setDescripcion("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed quis aliquet dui. .");
			v4.setFecha(sdf.parse("15-02-2020"));
			v4.setSalario(16500.0);
			v4.setDestacado(1);
			v4.setEstatus("Creada");
			
			Vacante v5 = new Vacante();
			v5.setId(5);
			v5.setNombre("Diseñador Gráfico");
			v5.setDescripcion("Se solicita diseñador grafico para los nuevos cambios en la página oficial");
			v5.setFecha(sdf.parse("18-02-2020"));
			v5.setSalario(12000.0);
			v5.setDestacado(1);
			v5.setImagen("empresa1.jpg");
			v5.setEstatus("Aprobada");
			
			/**
			 * Agregamos los 4 objetos a la lista
			 */
			lista.add(v1);
			lista.add(v2);
			lista.add(v3);
			lista.add(v4);
			lista.add(v5);
			
		} catch (ParseException e) {
			System.out.println("Error: "+e.getMessage());
		}
	}

	
	@Override
	public List<Vacante> buscarTodas() {
		return lista;
	}


	@Override
	public Vacante buscarPorId(Integer idVacante) {

		for(Vacante v : lista) { //como la lista de vacantes es de tipo 'Vacante', declaramos la variable temporal 'v' de tipo 'Vacante'
			if(v.getId()==idVacante) {
				return v;
			}
		}
		
		return null;
	}


	@Override
	public void guardar(Vacante vacante) {
		lista.add(vacante);
	}

}

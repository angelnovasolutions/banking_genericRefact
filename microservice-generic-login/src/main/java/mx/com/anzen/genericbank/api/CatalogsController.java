package mx.com.anzen.genericbank.api;

import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.anzen.genericbank.services.CatalogsService;
import mx.com.anzen.genericbank.models.States;

import java.util.List;

@RestController
public class CatalogsController {

	// Inyeccion de dependencias del servicio
	@Autowired
	private CatalogsService catalogsService;
	

	@RequestMapping(value = "/catalogs/insert/states/{id}/{state}")
	public String insertState(@PathVariable int id, @PathVariable String state) {
		
		// Variables y Constantes
		final int EXITOSO = 0;
		
		// Ejecutar consulta
		@SuppressWarnings("unchecked")
		Vector<Object> response = (Vector<Object>)catalogsService.insertState(id, state);
		
		// Validar respuesta
		return (Integer)response.get(0)==EXITOSO?"Exitoso":(String)response.get(1);

	}
	
	
	@RequestMapping(value="/catalogs/retrieve/states/{id}")
	public List<States> retrieveState(@PathVariable int id){
		return catalogsService.getState(id);
	}
}

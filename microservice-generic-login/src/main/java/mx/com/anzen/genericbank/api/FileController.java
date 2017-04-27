package mx.com.anzen.genericbank.api;

import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.anzen.genericbank.services.FileService;

@RestController
public class FileController {
	
	// Inyeccion de dependencias del servicio
	@Autowired
	private FileService fileService;

	
	@RequestMapping(value = "/file/layout")
	public String layout() {
		
		// Variables y Constantes
		final int EXITOSO = 0;
		
		// Ejecutar consulta
//		@SuppressWarnings("unchecked")
//		Vector<Object> response = (Vector<Object>)fileService.insertaLayout();
		fileService.insertaLayout();
		
		// Validar respuesta
		//return (Integer)response.get(0)==EXITOSO?"Exitoso":(String)response.get(1);
		
		return "Exitoso";

	}	

}

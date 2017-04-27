package mx.com.anzen.genericbank.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import mx.com.anzen.genericbank.models.FileDefinition;
import mx.com.anzen.genericbank.models.FileFields;
import mx.com.anzen.genericbank.models.FileLines;
import mx.com.anzen.genericbank.models.ValidationFields;

@Service
public class FileServiceImpl implements FileService {
	
	public void insertaLayout(){
		
		// Variables
		Map<String, Object> mpEstructuraLayout = new HashMap<String,Object>();
		
		try{
			// Se recupera el JSON
			String json = returnJSON2();
			
			System.out.print("json:");
			System.out.println(json);
			
			// Se convierte el JSON de configuracion del archivo en objeto JAVA
			mpEstructuraLayout = convertJSONConfiguration(json);
			
			// Se convierte el contenido del layout en objeto JAVA
			String[] arrayExample = layoutToObjectJAVA();
			
			// Guardar en base de datos
			int result = saveTransacction(arrayExample, mpEstructuraLayout);
		    
		    
		} catch (Exception ex){
			
		}

	}
	
	
	
	
	private String returnJSON() throws ClientProtocolException, IOException{
		
		// Invocar cliente REST
	    HttpClient client = new DefaultHttpClient();
	    
	    HttpPost post = new HttpPost("http://54.215.247.221:9092/Layout");
	    StringEntity s = new StringEntity("{\"IdFileType\": 1}");
	    s.setContentType("application/json");
	    post.setEntity(s);
	    post.setHeader("Accept", "application/json");
	     
	    ResponseHandler<String> handler = new BasicResponseHandler();
	    String json = client.execute(post, handler);

	    
	    return json.substring(1, json.length()-2);
	}
	
	
	private String returnJSON2(){
		
		String json = 	
				"{"+
						   "\"fileDefinition\":{"+
						      "\"idFileType\":\"1\","+
						      "\"fileType\":\"Layout - C\","+
						      "\"side\":\"3\","+
						      "\"fileLimit\":\"3\","+
						      "\"fileLayout\":\"u\","+
						      "\"idOperationLong\":\"2\","+
						      "\"fileLines\":{"+
						          "\"00\":{"+
						             "\"unique\":\"true\","+
						             "\"size\":\"125\","+
						             "\"fileFields\":["+
						                "{"+
						                   "\"nombre\":\"Tipo de Registro\","+
						                   "\"longField\":\"2\","+
						                   "\"start\":\"0\","+
						                   "\"end\":\"2\","+
						                   "\"format\":\"9\","+
						                   "\"validation\":{"+
						                      "\"integer\":2,"+
						                      "\"decimal\":0"+
						                   "}"+
						                "}, {"+
						                   "\"nombre\":\"Númerico de identificación del cliente\","+
						                   "\"longField\":\"12\","+
						                   "\"start\":\"2\","+
						                   "\"end\":\"14\","+
						                   "\"format\":\"9\","+
						                   "\"validation\":{"+
						                      "\"integer\":12,"+
						                      "\"decimal\":0"+
						                   "}"+
						                "}, {"+
						                   "\"nombre\":\"fecha de pago\","+
						                   "\"longField\":\"6\","+
						                   "\"start\":\"14\","+
						                   "\"end\":\"20\","+
						                   "\"format\":\"9\","+
						                   "\"validation\":{"+
						                      "\"integer\":6,"+
						                      "\"decimal\":0"+
						                   "}"+
						                "}, {"+
						                   "\"nombre\":\"Secuencial del archivo\","+
						                   "\"longField\":\"4\","+
						                   "\"start\":\"20\","+
						                   "\"end\":\"24\","+
						                   "\"format\":\"9\","+
						                   "\"validation\":{"+
						                      "\"integer\":4,"+
						                      "\"decimal\":0"+
						                   "}"+
						                "}, {"+
						                   "\"nombre\":\"Nombre de la empresa\","+
						                   "\"longField\":\"36\","+
						                   "\"start\":\"24\","+
						                   "\"end\":\"60\","+
						                   "\"format\":\"x\","+
						                   "\"validation\":{"+
						                      "\"integer\":0,"+
						                      "\"decimal\":0"+
						                   "}"+
						                "}, {"+
						                   "\"nombre\":\"Descripción del archivo\","+
						                   "\"longField\":\"20\","+
						                   "\"start\":\"60\","+
						                   "\"end\":\"80\","+
						                   "\"format\":\"x\","+
						                   "\"validation\":{"+
						                      "\"integer\":0,"+
						                      "\"decimal\":0"+
						                   "}"+
						                "}, {"+
						                   "\"nombre\":\"Naturaleza del archivo\","+
						                   "\"longField\":\"2\","+
						                   "\"start\":\"80\","+
						                   "\"end\":\"82\","+
						                   "\"format\":\"9\","+
						                   "\"validation\":{"+
						                      "\"integer\":2,"+
						                      "\"decimal\":0"+
						                   "}"+
						                "}, {"+
						                   "\"nombre\":\"Instrucciones para órdenes de pago\","+
						                   "\"longField\":\"40\","+
						                   "\"start\":\"82\","+
						                   "\"end\":\"122\","+
						                   "\"format\":\"x\","+
						                   "\"validation\":{"+
						                      "\"integer\":0,"+
						                      "\"decimal\":0"+
						                   "}"+
						                "}, {"+
						                   "\"nombre\":\"Versión del Layout\","+
						                   "\"longField\":\"1\","+
						                   "\"start\":\"122\","+
						                   "\"end\":\"123\","+
						                   "\"format\":\"x\","+
						                   "\"validation\":{"+
						                      "\"integer\":0,"+
						                      "\"decimal\":0"+
						                   "}"+
						                "}, {"+
						                   "\"nombre\":\"Volumen\","+
						                   "\"longField\":\"1\","+
						                   "\"start\":\"123\","+
						                   "\"end\":\"124\","+
						                   "\"format\":\"9\","+
						                   "\"validation\":{"+
						                      "\"integer\":1,"+
						                      "\"decimal\":0"+
						                   "}"+
						                "}, {"+
						                   "\"nombre\":\"Características del archivo\","+
						                   "\"longField\":\"1\","+
						                   "\"start\":\"124\","+
						                   "\"end\":\"125\","+
						                   "\"format\":\"9\","+
						                   "\"validation\":{"+
						                      "\"integer\":1,"+
						                      "\"decimal\":0"+
						                   "}"+
						                "}"+
						             "]"+
						          "},"+
						          "\"01\":{"+
						             "\"unique\":\"false\","+
						             "\"size\":\"218\","+
						             "\"fileFields\":["+
						               "{"+
						                  "\"nombre\":\"Tipo de Registro\","+
						                  "\"longField\":\"2\","+
						                  "\"start\":\"0\","+
						                  "\"end\":\"2\","+
						                  "\"format\":\"9\","+
						                  "\"validation\":{"+
						                     "\"integer\":2,"+
						                     "\"decimal\":0"+
						                  "}"+
						               "}, {"+
						                  "\"nombre\":\"Tipo de operación\","+
						                  "\"longField\":\"1\","+
						                  "\"start\":\"2\","+
						                  "\"end\":\"3\","+
						                  "\"format\":\"9\","+
						                  "\"validation\":{"+
						                     "\"integer\":1,"+
						                     "\"decimal\":0"+
						                  "}"+
						               "}, {"+
						                  "\"nombre\":\"Clave de la moneda\","+
						                  "\"longField\":\"3\","+
						                  "\"start\":\"3\","+
						                  "\"end\":\"6\","+
						                  "\"format\":\"9\","+
						                  "\"validation\":{"+
						                     "\"integer\":3,"+
						                     "\"decimal\":0"+
						                  "}"+
						               "}, {"+
						                  "\"nombre\":\"Importe\","+
						                  "\"longField\":\"18\","+
						                  "\"start\":\"6\","+
						                  "\"end\":\"24\","+
						                  "\"format\":\"9\","+
						                  "\"validation\":{"+
						                     "\"integer\":16,"+
						                     "\"decimal\":2"+
						                  "}"+
						               "}, {"+
						                  "\"nombre\":\"Tipo de cuenta\","+
						                  "\"longField\":\"2\","+
						                  "\"start\":\"24\","+
						                  "\"end\":\"26\","+
						                  "\"format\":\"9\","+
						                  "\"validation\":{"+
						                     "\"integer\":2,"+
						                     "\"decimal\":0"+
						                  "}"+
						               "}, {"+
						                  "\"nombre\":\"Número de cuenta\","+
						                  "\"longField\":\"20\","+
						                  "\"start\":\"26\","+
						                  "\"end\":\"46\","+
						                  "\"format\":\"9\","+
						                  "\"validation\":{"+
						                     "\"integer\":20,"+
						                     "\"decimal\":0"+
						                  "}"+
						               "}, {"+
						                  "\"nombre\":\"Referencia Alfanumérica\","+
						                  "\"longField\":\"40\","+
						                  "\"start\":\"46\","+
						                  "\"end\":\"86\","+
						                  "\"format\":\"x\","+
						                  "\"validation\":{"+
						                     "\"integer\":0,"+
						                     "\"decimal\":0"+
						                  "}"+
						               "}, {"+
						                  "\"nombre\":\"Beneficiario\","+
						                  "\"longField\":\"55\","+
						                  "\"start\":\"86\","+
						                  "\"end\":\"141\","+
						                  "\"format\":\"x\","+
						                  "\"validation\":{"+
						                     "\"integer\":0,"+
						                     "\"decimal\":0"+
						                  "}"+
						               "}, {"+
						                  "\"nombre\":\"Instrucciones\","+
						                  "\"longField\":\"40\","+
						                  "\"start\":\"141\","+
						                  "\"end\":\"181\","+
						                  "\"format\":\"x\","+
						                  "\"validation\":{"+
						                     "\"integer\":0,"+
						                     "\"decimal\":0"+
						                  "}"+
						               "}, {"+
						                  "\"nombre\":\"Descripción TEF\","+
						                  "\"longField\":\"24\","+
						                  "\"start\":\"181\","+
						                  "\"end\":\"205\","+
						                  "\"format\":\"x\","+
						                  "\"validation\":{"+
						                     "\"integer\":0,"+
						                     "\"decimal\":0"+
						                  "}"+
						               "}, {"+
						                  "\"nombre\":\"Clave de Banco\","+
						                  "\"longField\":\"4\","+
						                  "\"start\":\"205\","+
						                  "\"end\":\"208\","+
						                  "\"format\":\"9\","+
						                  "\"validation\":{"+
						                     "\"integer\":4,"+
						                     "\"decimal\":0"+
						                  "}"+
						               "}, {"+
						                  "\"nombre\":\"Referencia Numérica\","+
						                  "\"longField\":\"7\","+
						                  "\"start\":\"208\","+
						                  "\"end\":\"216\","+
						                  "\"format\":\"9\","+
						                  "\"validation\":{"+
						                     "\"integer\":7,"+
						                     "\"decimal\":0"+
						                  "}"+
						               "}, {"+
						                  "\"nombre\":\"Plazo\","+
						                  "\"longField\":\"1\","+
						                  "\"start\":\"216\","+
						                  "\"end\":\"218\","+
						                  "\"format\":\"9\","+
						                  "\"validation\":{"+
						                     "\"integer\":1,"+
						                     "\"decimal\":0"+
						                  "}"+
						               "}"+
						             "]"+
						          "},"+
						          "\"99\":{"+
						             "\"unique\":\"true\","+
						             "\"size\":\"53\","+
						             "\"fileFields\":["+
						               "{"+
						                  "\"nombre\":\"Tipo de Registro\","+
						                  "\"longField\":\"2\","+
						                  "\"start\":\"0\","+
						                  "\"end\":\"2\","+
						                  "\"format\":\"9\","+
						                  "\"validation\":{"+
						                     "\"integer\":2,"+
						                     "\"decimal\":0"+
						                  "}"+
						               "}, {"+
						                  "\"nombre\":\"Clave de la moneda\","+
						                  "\"longField\":\"3\","+
						                  "\"start\":\"2\","+
						                  "\"end\":\"5\","+
						                  "\"format\":\"9\","+
						                  "\"validation\":{"+
						                     "\"integer\":3,"+
						                     "\"decimal\":0"+
						                  "}"+
						               "}, {"+
						                  "\"nombre\":\"Número de abonos\","+
						                  "\"longField\":\"6\","+
						                  "\"start\":\"5\","+
						                  "\"end\":\"11\","+
						                  "\"format\":\"9\","+
						                  "\"validation\":{"+
						                     "\"integer\":6,"+
						                     "\"decimal\":0"+
						                  "}"+
						               "}, {"+
						                  "\"nombre\":\"Importe total de abonos\","+
						                  "\"longField\":\"18\","+
						                  "\"start\":\"11\","+
						                  "\"end\":\"29\","+
						                  "\"format\":\"9\","+
						                  "\"validation\":{"+
						                     "\"integer\":16,"+
						                     "\"decimal\":2"+
						                  "}"+
						               "}, {"+
						                  "\"nombre\":\"Número de cargos\","+
						                  "\"longField\":\"6\","+
						                  "\"start\":\"29\","+
						                  "\"end\":\"35\","+
						                  "\"format\":\"9\","+
						                  "\"validation\":{"+
						                     "\"integer\":6,"+
						                     "\"decimal\":0"+
						                  "}"+
						               "}, {"+
						                  "\"nombre\":\"Importe total de cargos\","+
						                  "\"longField\":\"18\","+
						                  "\"start\":\"35\","+
						                  "\"end\":\"53\","+
						                  "\"format\":\"9\","+
						                  "\"validation\":{"+
						                     "\"integer\":16,"+
						                     "\"decimal\":2"+
						                  "}"+
						               "}"+
						             "]"+
						          "}"+
						      "}"+
						   "}"+
						"}";
		
		
		return json;
		
	}
	
	
	
	private Map<String, Object> convertJSONConfiguration(String json){
		
		// Mapa para retornar estructura de layout en objeto JAVA, con lista den la definicion del layout y definicion de header, operation y footer
		Map<String, Object> mpEstructuraLayout = new HashMap<String,Object>();
		List<FileDefinition> lstFileDefinition = new ArrayList<FileDefinition>();
		List<FileFields> lstHeader = null;
		List<FileFields> lstOperation = null;
		List<FileFields> lstFooter = null;
		final String HEADER = "00", OPERATION="01", FOOTER="99";
		
		JSONParser parser = new JSONParser(); 
		
		try {

			// Se parsea el JSON a JSONObject
			JSONObject jsonObject = (JSONObject) parser.parse(json);
			
			// Se obtiene el Layout
			JSONObject fileDefinition = (JSONObject) jsonObject.get("fileDefinition");
			JSONObject lineas = (JSONObject) fileDefinition.get("fileLines");
			
			// Se obtiene el cabecero
			JSONObject header = (JSONObject) lineas.get(HEADER);
			lstHeader = convertJSONFields(parser, header); 
			
			// Se obtiene la operacion
			JSONObject operation = (JSONObject) lineas.get(OPERATION);
			lstOperation = convertJSONFields(parser, operation);
			
			// Se obtiene el pie de pagina
			JSONObject footer = (JSONObject) lineas.get(FOOTER);
			lstFooter = convertJSONFields(parser, footer);
	
			
			// Llenar definicion de Layout
			FileDefinition configuration = new FileDefinition((String)fileDefinition.get("idFileType"), (String)fileDefinition.get("fileType"), 
					(String)fileDefinition.get("side"), (String)fileDefinition.get("fileLimit"), 
					(String)fileDefinition.get("idOperationLong"), new FileLines((String)header.get("unique"), (String)header.get("size")), 
					new FileLines((String)operation.get("unique"), (String)operation.get("size")), 
					new FileLines((String)footer.get("unique"), (String)footer.get("size")));
			
			lstFileDefinition.add(configuration);
			
			
			// Se pobla el mapa con la estructura del JSON
			mpEstructuraLayout.put("fileDefinition", lstFileDefinition);
			mpEstructuraLayout.put("header", lstHeader);
			mpEstructuraLayout.put("operation", lstOperation);
			mpEstructuraLayout.put("footer", lstFooter);
		
		} catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
		return mpEstructuraLayout;
	}
	
	
	private List<FileFields> convertJSONFields(JSONParser parser, JSONObject line) throws ParseException{

		// Retornar lista con los campos y sus validaciones
		List<FileFields> lstCampos = new ArrayList<FileFields>();
		FileFields fileFields = null;
		
		// Se obtienen los campos del JSON
		JSONArray fields = (JSONArray) line.get("fileFields");
	
		for(int i=0; i<fields.size(); i++){
			// Se obtiene campo por campo de cada seccion (header, operation, footer)
			JSONObject row = (JSONObject)parser.parse(fields.get(i).toString());						
			
			// Se obtiene la validacion de cada campo
			JSONObject validation = (JSONObject)row.get("validation");
			
			// Se añade el nuevo campo a la lista
			fileFields = new FileFields((String)row.get("nombre"), (String)row.get("longField"), (String)row.get("start"), (String)row.get("end"), (String)row.get("format"),
					new ValidationFields((Long)validation.get("integer"), (Long)validation.get("decimal")));
			lstCampos.add(fileFields);
			
		}
		
		return lstCampos;
	}
	
	
	private int saveTransacction(String[] json, Map<String, Object> mpConfiguration){
		
		StringBuilder customerFiles = new StringBuilder();
		StringBuilder fileDetails = new StringBuilder();
		
		for(int i=0; i<json.length; i++){
			
			String operation = "";
			if (json[i].substring(0,2).equals("00"))
				operation = "header";
			else if (Integer.parseInt(json[i].substring(0,2)) > 0 && Integer.parseInt(json[i].substring(0,2)) < 98 )
				operation = "operation";
			else if (json[i].substring(0,2).equals("99"))
				operation = "footer";
			
			System.out.print("operation: ");
			System.out.println(operation);
			
		
			
			@SuppressWarnings("unchecked")
			List<FileFields> lstOperation = ((List<FileFields>)mpConfiguration.get(operation));
			
			
			concatenateTransacction(lstOperation, json[i], customerFiles, fileDetails);
			
			
			System.out.print("lstOperation: ");
			System.out.println(lstOperation.size());
		}
		
		
		return 0;
	}
	
	
	private void concatenateTransacction(List<FileFields> lstOperation, String line, StringBuilder customerFiles, StringBuilder fileDetails){
		
		System.out.println("--------------------------------------------------------------------------------------------");
		
		for(FileFields aux : lstOperation){
			
			System.out.println(line.substring(  Integer.parseInt(aux.getStart())  ,  Integer.parseInt(aux.getEnd())  ));
//			System.out.println(aux.getNombre());
//			System.out.println(aux.getLongField());
//			System.out.println(aux.getStart());
//			System.out.println(aux.getEnd());
			
		}
		System.out.println(" ");
		System.out.println("--------------------------------------------------------------------------------------------");
		
	}
	
	
	private String[] layoutToObjectJAVA(){
		
		String[] arrayExample = {"000000000000151004170001                              abcdef             archivo02                         ordenes de pago112",
				"0121230000000000000100201300000000000123456789                             Referencia1                                           beneficiario                           Instrucciones             Descripcion123401234569",
				"0121230000000000000100201300000000000123456789                             Referencia2                                           beneficiario                           Instrucciones             Descripcion123401234569",
				"0121230000000000000100201300000000000123456789                             Referencia3                                           beneficiario                           Instrucciones             Descripcion123401234569",
				"0121230000000000000100201300000000000123456789                             Referencia4                                           beneficiario                           Instrucciones             Descripcion123401234569",
				"0121230000000000000100201300000000000123456789                             Referencia5                                           beneficiario                           Instrucciones             Descripcion123401234569",
				"0121230000000000000100201300000000000123456789                             Referencia6                                           beneficiario                           Instrucciones             Descripcion123401234569",
				"0121230000000000000100201300000000000123456789                             Referencia7                                           beneficiario                           Instrucciones             Descripcion123401234569",
				"0121230000000000000100201300000000000123456789                             Referencia8                                           beneficiario                           Instrucciones             Descripcion123401234569",
				"0121230000000000000100201300000000000123456789                             Referencia9                                           beneficiario                           Instrucciones             Descripcion123401234569",
				"0121230000000000000100201300000000000123456789                             ReferenciaA                                           beneficiario                           Instrucciones             Descripcion123401234569",
				"99123123456000000000000010050123456000000000000020020"};
		
		return arrayExample; 
	}
}


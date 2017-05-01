package mx.com.anzen.genericbank.models;

public class FileFields {

	// Atributos
	private String nombre;
	private String longField;
	private String start;
	private String end;
	private String format;
	private ValidationFields validationFields;
	
	// Constructor
	public FileFields() {}
	
	public FileFields(String nombre, String longField, String start, String end, String format,
			ValidationFields validationFields) {
		this.nombre = nombre;
		this.longField = longField;
		this.start = start;
		this.end = end;
		this.format = format;
		this.validationFields = validationFields;
	}
	
	// Getters and Setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getLongField() {
		return longField;
	}
	public void setLongField(String longField) {
		this.longField = longField;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public ValidationFields getValidationFields() {
		return validationFields;
	}
	public void setValidationFields(ValidationFields validationFields) {
		this.validationFields = validationFields;
	}
}

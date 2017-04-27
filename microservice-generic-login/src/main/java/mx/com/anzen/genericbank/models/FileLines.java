package mx.com.anzen.genericbank.models;

public class FileLines {
	
	// Atributos
	private String unique;
	private String size;
	
	// Constructor
	public FileLines() {}
	
	public FileLines(String unique, String size) {
		this.unique = unique;
		this.size = size;
	}
	
	
	// Getters and Setters
	public String getUnique() {
		return unique;
	}
	public void setUnique(String unique) {
		this.unique = unique;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}	
}

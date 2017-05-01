package mx.com.anzen.genericbank.models;

public class ValidationFields {
	
	// Atributos
	private long integer;
	private long decimal;
	
	// Constructor
	public ValidationFields() {}
	public ValidationFields(long integer, long decimal) {
		this.integer = integer;
		this.decimal = decimal;
	}
	
	// Getters and Setters
	public long getInteger() {
		return integer;
	}
	public void setInteger(long integer) {
		this.integer = integer;
	}
	public long getDecimal() {
		return decimal;
	}
	public void setDecimal(long decimal) {
		this.decimal = decimal;
	}
}

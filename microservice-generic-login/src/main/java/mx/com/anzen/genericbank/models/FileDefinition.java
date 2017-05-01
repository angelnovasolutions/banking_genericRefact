package mx.com.anzen.genericbank.models;

public class FileDefinition {
	
	// Atributos
	private String idFileType;
	private String fileType;
	private String side;
	private String fileLimit;
	private String idOperationLong;
	private FileLines header;
	private FileLines operation;
	private FileLines footer;
	
	// Constructor
	public FileDefinition() {}
	
	public FileDefinition(String idFileType, String fileType, String side, String fileLimit, 
			String idOperationLong, FileLines header, FileLines operation, FileLines footer) {
		this.idFileType = idFileType;
		this.fileType = fileType;
		this.side = side;
		this.fileLimit = fileLimit;
		this.idOperationLong = idOperationLong;
		this.header = header;
		this.operation = operation;
		this.footer = footer;
	}
	
	// Getters and Setters
	public String getIdFileType() {
		return idFileType;
	}
	public void setIdFileType(String idFileType) {
		this.idFileType = idFileType;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getSide() {
		return side;
	}
	public void setSide(String side) {
		this.side = side;
	}
	public String getFileLimit() {
		return fileLimit;
	}
	public void setFileLimit(String fileLimit) {
		this.fileLimit = fileLimit;
	}
	public String getIdOperationLong() {
		return idOperationLong;
	}
	public void setIdOperationLong(String idOperationLong) {
		this.idOperationLong = idOperationLong;
	}
	public FileLines getHeader() {
		return header;
	}
	public void setHeader(FileLines header) {
		this.header = header;
	}
	public FileLines getOperation() {
		return operation;
	}
	public void setOperation(FileLines operation) {
		this.operation = operation;
	}
	public FileLines getFooter() {
		return footer;
	}
	public void setFooter(FileLines footer) {
		this.footer = footer;
	}
}

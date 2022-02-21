package model;

public class Student {
	private String name;
	private int natIDCol;
	private String code;
	public Student(String name, int natIDCol, String code) {
		this.name = name;
		this.natIDCol = natIDCol;
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNatIDCol() {
		return natIDCol;
	}
	public void setNatIDCol(int natIDCol) {
		this.natIDCol = natIDCol;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
	
	
	
}

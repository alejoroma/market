package models.entity;

public enum TypePerson {
	MEN, WOMEN, MEN_AND_WOMEN;
	
	public String toString() {
		String enumFormat =  name().substring(0, 1) + name().substring(1).toLowerCase();
		return enumFormat;
	}
}

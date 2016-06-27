package models.entity;

public enum StatusProduct {

	AVAILABLE,
	NOT_AVAILABLE;
	
	public String toString(){
		String variables = name().substring(0,1)+name().substring(1).toLowerCase();
		return variables;
	}
}
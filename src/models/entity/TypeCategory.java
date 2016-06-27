package models.entity;

public enum TypeCategory {

	CLOTHES,
	TECHNOLOGY,
	HOME,
	BEAUTY,
	HEALTH,
	TOYS,
	SPORTS,
	PETS;
	
	public String toString(){
		String variables = name().substring(0,1)+name().substring(1).toLowerCase();
		return variables;
	}
}
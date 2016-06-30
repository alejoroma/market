package models.entity;

public enum TypeProduct {
	TECHNOLOGY, FOOTWEAR,  CLOTHES, ACCESSORIES, HEALTH, SPORTS, PETS;
	
	public String toString() {
		String enumFormat =  name().substring(0, 1) + name().substring(1).toLowerCase();
		return enumFormat;
	}
}
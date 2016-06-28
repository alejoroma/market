package models.entity;

public enum TypeProduct {
	CALZADO, CAMISETA, PANTALONES, GAFAS;
	
	public String toString() {
		String enumFormat =  name().substring(0, 1) + name().substring(1).toLowerCase();
		return enumFormat;
	}
}
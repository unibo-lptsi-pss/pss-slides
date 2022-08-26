package it.unibo.apice.oop.p19reflection.annotations;

public class Product {
	
	private final String name;
	private final int id;
	private final double quantity;
	
	public Product(final String name, final int id, final double quantity) {
		this.name = name;
		this.id = id;
		this.quantity = quantity;
	}

	@ToString( separator = ";" )
	public String getName() {
		return name;
	}

	@ToString( separator = ";", associationSymbol = ":") 
	public int getId() {
		return id;
	}
	
	@ToString( separator = ";", customName = "qty") 
	public double getQuantity() {
		return quantity;
	}
}

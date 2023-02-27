package supermaket.management;

public abstract class Product {
	protected String name;
	protected String code;
	protected int quantity;
	protected double price;

	public Product(String name, String code, int quantity, double price) {
		this.name = name;
		this.code = code;
		this.quantity = quantity;
		this.price = price;
	}

	abstract void consumptionLevel();
}

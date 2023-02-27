package supermaket.management;

import java.text.ParseException;

public class Main {

	public static void vat(Product product) {
		if (product instanceof China || product instanceof Electric) {
			System.out.println("VAT: " + product.price * 0.1);
		} else if (product instanceof Food) {
			System.out.println("VAT: " + product.price * 0.05);
		}
	}

	public static void main(String[] args) throws ParseException {
		System.out.println("===Valid Food===");
		Food salad = new Food("Salad", "S001", 5, 12.0, "01/01/2023", "10/03/2023");
		salad.validateDate();
		salad.validateQuantity();
		vat(salad);
		salad.consumptionLevel();
		System.out.println("===Invalid Food===");
		Product expiredSalad = new Food("Salad", "S001", 5, 15.0, "01/01/2023", "20/01/2023");
		vat(expiredSalad);
		expiredSalad.consumptionLevel();
	}
}

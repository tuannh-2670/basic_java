package supermaket.management;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Food extends Product {
	private Date mfgDate;
	private Date expDate;
	private Date today = new Date();

	public Food(String name, String code, int quantity, double price, String mfgDate, String expDate)
			throws ParseException {
		super(name, code, quantity, price);
		this.mfgDate = convertDate(mfgDate);
		this.expDate = convertDate(expDate);
	}

	@Override
	void consumptionLevel() {
		if (validateDate() && validateQuantity()) {
			if (quantity > 0 && today.compareTo(expDate) > 0) {
				System.out.println("Hard to sell");
			} else {
				System.out.println("No result");
			}
		} else {
			System.out.println("Invalid food!!!");
		}

	}

	public Date convertDate(String date) throws ParseException {
		Date convertedDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);
		return convertedDate;
	}

	public boolean validateDate() {
		if (expDate.compareTo(mfgDate) >= 0) {
			System.out.println("Valid MFG & EXP Date");
			return true;
		} else {
			System.out.println("Invalid MFG & EXP Date!!!");
			return false;
		}
	}

	public boolean validateQuantity() {
		if (quantity >= 0) {
			System.out.println("Valid quantity");
			return true;
		} else {
			System.out.println("Invalid quantity!!!");
			return false;
		}
	}
}

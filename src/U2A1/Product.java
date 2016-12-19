// Reece Yang
//
// This class models a product.

public class Product {

	// Instance fields
	private String name;
	private double cost;

	// Constants
	private static final double TAX_RATE = 0.065;

	// Parametric constructor
	public Product(String n, double c) {

		name = n;
		cost = c;
	}

	// Deducts from the cost the
	// discount passed to it as a percent
	public void discount(int percent) {

		cost *= (100.0 - percent) / 100.0;
	}

	// Subtracts from the cost the value
	// passed to it as a dollar amount
	public void dollarsOff(int dollars) {

		cost -= dollars;
	}

	// Determines the tax of the product
	// and adds it to the cost
	public void tax() {

		cost += cost * TAX_RATE;
	}

	// Accessor methods
	public String getName() {

		return name;
	}

	public double getCost() {

		return cost;
	}
}
// Reece Yang
//
// This driver class will
// demonstrate the Product class

public class U2A1 {

	public static void main(String[] args) {

		Product a = new Product("Jeans", 34.95);
		Product b = new Product("Sweater", 49.99);
		Product c = new Product("Shoes", 99.95);

		a.discount(30);
		a.tax();

		b.discount(40);
		b.discount(30);
		b.tax();

		c.dollarsOff(5);
		c.discount(30);
		c.tax();

		System.out.printf("Item: %s\n", a.getName());
		System.out.printf("Cost: $ %.2f%n\n\n", a.getCost());

		System.out.printf("Item: %s\n", b.getName());
		System.out.printf("Cost: $ %.2f%n\n\n", b.getCost());

		System.out.printf("Item: %s\n", c.getName());
		System.out.printf("Cost: $ %.2f%n\n\n", c.getCost());
	}
}

/*

Item: Jeans
Cost: $ 26.06


Item: Sweater
Cost: $ 22.36


Item: Shoes
Cost: $ 70.79

*/
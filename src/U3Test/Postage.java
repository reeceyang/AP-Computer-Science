// Reece Yang
//
// This class calculates the cost to mail an item.

public class Postage {

	private String type;
	private double weight;

	public Postage(String t, double w) {

		type = t;
		weight = w;
	}

	public double calculate() {

		double cost = 0.0;

		// If mail is Priority mail
		if (type.equals("P")) {

			if (weight <= 16) {

				cost = 3.50;
			}
			else if (weight <= 32) {

				cost = 3.95;
			}
			else {

				// Add $1.20 to $3.95 for every 16 oz (or fraction of) above 32 oz
				cost = 3.95 + (1.20 * Math.ceil((weight - 32) / 16));
			}
		}

		// If mail is First Class mail
		if (type.equals("F")) {

			if (weight <= 13) {

				// $0.34 for the first ounce and $0.21 for every ounce (or fraction of)
				// afterwards
				cost = 0.34 + (0.21 * Math.ceil(weight - 1));
			}
			// Priority rates apply after 13 oz
			else if (weight <= 16) {

				cost = 3.50;
			}
			else if (weight <= 32) {

				cost = 3.95;
			}
			else {

				// Add $1.20 to $3.95 for every 16 oz (or fraction of) above 32 oz
				cost = 3.95 + (1.20 * Math.ceil((weight - 32) / 16));
			}
		}
		return cost;
	}

	public String getType() {

		return type;
	}

	public double getWeight() {

		return weight;
	}
}

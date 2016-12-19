// Reece Yang
//
// This class will simulate the growth
// of a roach population.

public class RoachPopulation {

	// Represents the actual population
	private int roaches;

	// Default constructor
	public RoachPopulation() {

		// Starts the roach population at 100
		roaches = 100;
	}

	// Simulates a period in which
	// the population doubles
	public void timePasses() {

		roaches *= 2;
	}

	// Simulates spraying with insecticide
	public void spray() {

		roaches = (int) roaches / 4;
	}

	// Returns the current size
	// of the population
	public int getRoaches() {

		return roaches;
	}
}
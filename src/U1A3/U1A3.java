// Reece Yang
//
// This class will test the methods
// of the RoachPopulation class

public class U1A3 {

	public static void main(String[] args) {

		// Create an instance of RoachPopulation
		RoachPopulation r = new RoachPopulation();

		r.timePasses();
		System.out.println(r.getRoaches());

		r.spray();
		System.out.println(r.getRoaches());

		r.spray();
		System.out.println(r.getRoaches());

		r.timePasses();
		System.out.println(r.getRoaches());
	}
}

/*

200
50
12
24

*/
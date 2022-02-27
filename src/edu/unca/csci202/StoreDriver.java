package edu.unca.csci202;

/**
 * Main class to generate and run GraceryStores
 * @author Taylor Van Aken
 */
public class StoreDriver {

	/**
	 * Tests and simulates any amount of stores and simulations
	 * within these stores.
	 * @param args
	 */
	public static void main(String[] args) {

		GroceryStore publix = new GroceryStore(3);
		GroceryStore ingles = new GroceryStore(4);
		
		publix.run(1000, 0.1, 2, 50);
		publix.printData();
		
		System.out.println();
		
		publix.run(1000, 0.1, 3, 30);
		publix.printData();
		
		System.out.println();
		
		ingles.run(500, 0.3, 1, 25);
		ingles.printData();
		
		System.out.println();
		
		ingles.run(1000, 0.2, 2, 35);
		ingles.printData();
	}

}

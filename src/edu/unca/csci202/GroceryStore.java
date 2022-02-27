package edu.unca.csci202;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Random;

/**
 * Represents a store with a set number of checout lines
 * @author Taylor Van Aken
 */
public class GroceryStore {
	
	private final static int DEFAULT_CAPACITY = 100;
	ArrayList<Queue> registers;
	private int lines;
	private int time;
	private double prob;
	private int speed;
	private int maxItems;
	private int totalServed;
	private int[] maxLength;
	
	/**
	 * Creates a new store and sets the number of checout
	 * lines to be inside, represented by an ArrayList.
	 * @param lines number of lines contained within the store
	 */
	public GroceryStore(int lines) {
		this.lines = lines;
		maxLength = new int[lines];
		registers = new ArrayList<Queue>(lines);

		for (int i = 0; i < lines; i++) {
			registers.add(new ArrayDeque<Customer>(DEFAULT_CAPACITY));
		}
	}
	
	/**
	 * Simulates customers shopping in the store for a set amount of time steps.
	 * @param time number of time steps to be simulated
	 * @param prob probability of a customer to arrive at a line per time step.
	 * @param speed the amount of time steps it takes for a cashier to bag a 
	 * customer's items.
	 * @param maxItems the maximum number of items a customer is allowed to carry.
	 */
	public void run(int time, double prob, int speed, int maxItems) {
		Random rand = new Random();
		this.time = time;
		this.prob = prob;
		this.speed = speed;
		this.maxItems = maxItems;
		totalServed = 0;
		
		for (int i = 0; i < lines; i++) {
			registers.get(i).clear();
		}
		
		while(time > 0) {
			
			if (rand.nextDouble() < prob) {
				getShortestLine();
			}
			
			for (int i = 0; i < lines; i++) {
				if (registers.get(i).size() != 0) {
					Customer front = (Customer) registers.get(i).element();
					front.itemChecked();
					if (front.getCheckoutTime() == 0) {
						registers.get(i).remove();
						totalServed++;
					}
				}
			}
			
			time--;
		}
	}
	
	/**
	 * Prints the data for the simulated store from each run() call.
	 */
	public void printData() {
		
		System.out.println("Number of timesteps: " + time);
		System.out.println("Number of lines: " + lines);
		System.out.println("Probability of customer arriving: " + prob);
		System.out.println("Time per item: " + speed);
		System.out.println("Maximum number of items: " + maxItems);
		for (int i = 0; i < lines; i++) {
			System.out.println("Maximum length of line " + i + " is: " + maxLength[i]);
			System.out.println("Customers left in line " + i + " is: " + registers.get(i).size());
		}
		System.out.println("Total number of customers served is: " + totalServed);
		
	}
	
	/**
	 * Iterates through the ArrayList of lines and finds the one
	 * with the smalled size to send the newly generated customer their.
	 * @return returns the shortest line within the registers ArrayList.
	 */
	public Queue<Customer> getShortestLine() {
		Random rand = new Random();
		Queue<Customer> shortest = registers.get(0);
		Queue<Customer> currentRegister;
		Queue<Customer> nextRegister;
		int index = 0;
		
		for (int i = 0; i < lines - 1; i++) {
			currentRegister = registers.get(i);
			nextRegister = registers.get(i+1);

			if (nextRegister.size() < shortest.size()) {
				shortest = nextRegister;
				index = i+1;
			}
		}
		Customer customer = new Customer(rand.nextInt(maxItems) + 1, speed);
		shortest.add(customer);
		if (shortest.size() > maxLength[index]) {
			maxLength[index] = shortest.size();
		}
		return shortest;
	}
}

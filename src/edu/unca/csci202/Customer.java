package edu.unca.csci202;

/**
 * Customers to be represented in each line within
 * a grocery store.
 * @author Taylor Van Aken
 */
public class Customer {

	private int items;
	private int checkoutTime;
	private int bagTime;
	
	/**
	 * Creates a customer and sets their total checkout time
	 * by multiplying total items by the speed of the cashier.
	 * @param items how many items the customer is purchasing
	 * @param bagTime speed of the cashiers for each store
	 */
	public Customer(int items, int bagTime) {
		this.bagTime = bagTime;
		this.items = items;
		setCheckoutTime(items * bagTime);
	}

	/**
	 * Gets number of items customer is carrying
	 * @return items
	 */
	public int getItems() {
		return items;
	}

	/**
	 * Sets number of items customer is caryying
	 * @param items
	 */
	public void setItems(int items) {
		this.items = items;
	}

	/**
	 * Gets the total time to checkout the customer
	 * @return checkoutTime
	 */
	public int getCheckoutTime() {
		return checkoutTime;
	}

	/**
	 * Sets the total time to checkout the customer
	 * @param checkoutTime
	 */
	public void setCheckoutTime(int checkoutTime) {
		this.checkoutTime = checkoutTime;
	}
	
	/**
	 * Decrements checoutTime by one unit.
	 * @return checkoutTime - 1
	 */
	public int itemChecked() {
		return checkoutTime--;
	}
}

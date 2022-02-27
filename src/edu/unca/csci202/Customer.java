package edu.unca.csci202;

/**
 * 
 * @author Taylor Van Aken
 *
 */
public class Customer {

	private int items;
	private int checkoutTime;
	private int bagTime;
	
	public Customer(int items, int bagTime) {
		this.bagTime = bagTime;
		this.items = items;
		setCheckoutTime(items * bagTime);
	}

	public int getItems() {
		return items;
	}

	public void setItems(int items) {
		this.items = items;
	}

	public int getCheckoutTime() {
		return checkoutTime;
	}

	public void setCheckoutTime(int checkoutTime) {
		this.checkoutTime = checkoutTime;
	}
	
	public int itemChecked() {
		return checkoutTime--;
	}
}

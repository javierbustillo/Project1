import java.util.ArrayList;

public abstract class Restaurant {
	//instance variables
	protected ArrayList<Customer> customers;
	protected int currentTurn;
	private double profit;
	protected int unsatisfiedCustomers;
	private Boolean isOpen;
	protected int customersInRestaurant;
	protected int wait;
	protected int interactionCounter;

	
	public Restaurant(ArrayList<Customer> customers) {
		this.customers = customers;
		currentTurn = 1;
		profit = 0;
		unsatisfiedCustomers = 0;
		isOpen = true;
		wait = 0;
		interactionCounter = 0;
	}
	
	/*
	 * Sets isOpen to false
	 */
	
	public void closeRestaurant() {
		isOpen = false;
	}
	/*
	 * Sets the current turn to the next turn
	 * Once turn ends, the wait is reduced
	 */
	public void nextTurn() {
		currentTurn++;
		if(wait>0)
			setWait(getWait()-1);
	}
	/*
	 * Picks next customer to take order
	 */
	
	public abstract void takeNewOrder();
	
	/*
	 * Removes customers who are unpatient 
	 */
	
	public abstract void updateCustomerStatus();
	
	/*
	 * Checks if a customer can take order
	 * if wait == 0 then there isn't an order in the kitchen
	 */
	
	public boolean isKitchenAvailable(){
		return wait==0;
	}
	/*
	 * Moves customers from the input arrayList into the line when their arrival turn
	 * is equal to the current turn
	 */
	public abstract void receiveCustomers();
	
	/*
	 * Runs the simulation until all the customers in the input array are taken care of
	 * Updates profit and unsatisfiedCustomers values 
	 */
	public void simulate() {
		while(isOpen()) {
			receiveCustomers();
			if(hasNextCustomer()) {

				if(isKitchenAvailable()) {
					updateCustomerStatus();
					takeNewOrder();
				}
				nextTurn();
			}
			else {
				closeRestaurant();
			}
		}
	}
	/*
	 * @return isOpen  the boolean value of isOpen
	 */
	public Boolean isOpen() {
		return isOpen;
	}
	
	/*
	 * @return currentTurn the integer value of the current turn
	 */
	public int getCurrentTurn() {
		return currentTurn;
	}
	
	/*
	 * @return profit the double value of profit
	 */
	
	public double getProfit() {
		return profit;
	}
	/*
	 * Sets the amount of unsatisfied customers
	 * @param cust integer value, overrides the current value of unsatisfied customers
	 */
	public void setUnsatisfiedCustomers(int cust) {
		unsatisfiedCustomers = cust;
	}
	/*
	 * @return unsatisfiedCustomers the amount of unsatisfiedCustomers integer value
	 */
	
	public int getUnsatisfiedCustomers() {
		return unsatisfiedCustomers;
	}
	
	/*
	 * Checks if all the customers in the input array have been accounted for or if there are still
	 * customers in restaurant
	 * If there are still customers in restaurant then it returns true, if there are customers in input array
	 * that haven't been accounted for then it returns true
	 * @return boolean
	 */
	public Boolean hasNextCustomer() {
		return interactionCounter < customers.size()  || customersInRestaurant>0;
	}
	/*
	 * @return customers an ArrayList of the customer input 
	 */
	public ArrayList<Customer> getCustomers() {
		return customers;
	}
	
	/*
	 * @param profit value that is received is added to the total profit
	 */
	public void addToProfit(double profit) {
		this.profit += profit;
	}
	/*
	 * @param wait replaces the current wait value
	 */
	public void setWait(int wait) {
		this.wait = wait;
	}
	/*
	 * @return wait the current wait
	 */
	public int getWait() {
		return wait;
	}
	/*
	 * @param size replaces the current amount of customers in restaurant
	 */
	public void setCustomersInRestaurant(int size) {
		customersInRestaurant = size;
	}
	/*
	 * @return customersInRestaurant the amount of customers in the restaurant
	 */
	
	public int getCustomersInRestaurant() {
		return customersInRestaurant;
	}
	
	

}

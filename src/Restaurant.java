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
	
	public void closeRestaurant() {
		isOpen = false;
	}
	
	public void nextTurn() {
		currentTurn++;
		if(wait>0)
			setWait(getWait()-1);
	}
	
	public abstract void takeNewOrder();
	
	public abstract void updateCustomerStatus();
	
	public boolean isKitchenAvailable(){
		return wait==0;
	}
	
	public abstract void receiveCustomers();
	
	
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
	
	public Boolean isOpen() {
		return isOpen;
	}
	
	public int getCurrentTurn() {
		return currentTurn;
	}
	
	public double getProfit() {
		return profit;
	}
	
	public void setUnsatisfiedCustomers(int cust) {
		unsatisfiedCustomers = cust;
	}
	
	public int getUnsatisfiedCustomers() {
		return unsatisfiedCustomers;
	}
	
	public Boolean hasNextCustomer() {
		return interactionCounter < customers.size()  || customersInRestaurant>0;
	}
	
	public ArrayList<Customer> getCustomers() {
		return customers;
	}
	
	public void addToProfit(double profit) {
		this.profit += profit;
	}
	
	public void setWait(int wait) {
		this.wait = wait;
	}
	
	public int getWait() {
		return wait;
	}
	
	public void setCustomersInRestaurant(int size) {
		customersInRestaurant = size;
	}
	
	public int getCustomersInRestaurant() {
		return customersInRestaurant;
	}
	
	

}

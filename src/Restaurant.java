
public abstract class Restaurant {
	//instance variables
	private Customer[] customers;
	private int currentTurn;
	private double profit;
	private int unsatisfiedCustomers;
	private Boolean isOpen;
	private int customersInRestaurant;
	private int wait;
	
	public Restaurant(Customer[] customers) {
		this.customers = customers;
		currentTurn = 1;
		profit = 0;
		unsatisfiedCustomers = 0;
		isOpen = true;
		wait = 0;
	}
	
	public void closeRestaurant() {
		isOpen = false;
	}
	
	public void nextTurn() {
		currentTurn++;
	}
	
	public abstract void takeNewOrder();
	
	public abstract void updateCustomerStatus();
	
	public abstract Boolean isKitchenAvailable();
	
	public abstract void receiveCustomers();
	
	
	public void simulate() {
		while(isOpen()) {
			receiveCustomers();
			if(hasNextCustomer()) {
				if(isKitchenAvailable()) {
					updateCustomerStatus();
					takeNewOrder();
				}
				else {
					setWait(getWait()-1);
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
		return customersInRestaurant>0;
	}
	
	public Customer[] getCustomers() {
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

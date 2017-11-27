
public abstract class Restaurant {
	//instance variables
	protected Customer[] customers;
	protected int currentTurn;
	private double profit;
	protected int unsatisfiedCustomers;
	private Boolean isOpen;
	protected int customersInRestaurant;
	protected int wait;
	protected int interactionCounter;

	
	public Restaurant(Customer[] customers) {
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
				setWait(getWait()-1);
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
		return interactionCounter < customers.length  || customersInRestaurant>0;
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


public class Restaurant {
	//instance variables
	private Customer[] customers;
	private int turns;
	private float profit;
	private int unsatisfiedCustomers;
	private Boolean isOpen;
	
	public Restaurant(Customer[] customers) {
		this.customers = customers;
		turns = 0;
		profit = 0;
		unsatisfiedCustomers = 0;
		isOpen = true;
	}
	
	public void closeRestaurant() {
		isOpen = false;
	}
	
	public void takeNewOrder() {
		
	}
	
	public void updateCustomerStatus() {
		
	}
	
	public void simulate() {
		
	}
	
	public Boolean isOpen() {
		return isOpen;
	}
	
	public int getTurns() {
		return turns;
	}
	
	public float getProfit() {
		return profit;
	}
	
	public int getUnsatisfiedCustomers() {
		return unsatisfiedCustomers;
	}
	

}

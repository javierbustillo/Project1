
public class Restaurant {
	//instance variables
	private Customer[] customers;
	private int turns;
	private float profit;
	private int customersSatisfied;
	
	public Restaurant(Customer[] customers) {
		this.customers = customers;
		turns = 0;
		profit = 0;
		customersSatisfied = 0;
	}

}

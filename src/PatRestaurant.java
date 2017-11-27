
public class PatRestaurant extends Restaurant {
	
	private SLLRestaurantQueue<Customer> restaurantQueue;
	int totalCustomers;
	
	public PatRestaurant(Customer[] customers){
		super(customers);
		restaurantQueue = new SLLRestaurantQueue<Customer>();
		totalCustomers=0;
	}
	
	@Override
	public void takeNewOrder() {
		if(restaurantQueue.size()>0&&wait==0){
			setWait(restaurantQueue.first().getTimeToPrepare());
			addToProfit(restaurantQueue.dequeue().getCostOfOrder());
			customersInRestaurant--;
		}
	}

	
	@Override
	public void updateCustomerStatus() {
	
		while(!restaurantQueue.isEmpty()&&restaurantQueue.first().getArrival()+restaurantQueue.first().getPatience()<currentTurn){
				restaurantQueue.dequeue();
				unsatisfiedCustomers++;
				customersInRestaurant--;
		}
	}


	@Override
	public void receiveCustomers() {
		//add variable for total customers traveled
		for(int i=totalCustomers; i<customers.length&&customers[i].getArrival()<=currentTurn; i++){
				totalCustomers++;
				restaurantQueue.enqueue(customers[i]);
				customersInRestaurant++;
				interactionCounter++;	
		}
	}
}

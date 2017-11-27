
public class PatRestaurant extends Restaurant {
	
	private RestaurantQueueList<Customer> customersInLine;
	
	public PatRestaurant(Customer[] customers){
		super(customers);
		customersInLine = new RestaurantQueueList<Customer>();
	}
	
	
	@Override
	public void takeNewOrder() {
		if(customersInLine.size()>0&&wait==0){
			setWait(customersInLine.get().getTimeToPrepare());
			addToProfit(customersInLine.remove().getCostOfOrder());
			customersInRestaurant--;
		}
	}

	
	@Override
	public void updateCustomerStatus() {
		while(!customersInLine.isEmpty()&&customersInLine.get(0).getArrival()+customersInLine.get(0).getPatience()<currentTurn){
			customersInLine.remove(0);
			unsatisfiedCustomers++;
			customersInRestaurant--;
		}
	}

	@Override
	public void receiveCustomers() {
		for(int i=interactionCounter; i<customers.length&&customers[i].getArrival()<=currentTurn; i++){
			customersInLine.add(customers[i]);
			customersInRestaurant++;
			interactionCounter++;	
		}	
		
	}
}

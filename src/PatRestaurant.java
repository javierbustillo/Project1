
public class PatRestaurant extends Restaurant {
	
	private SLLRestaurantQueue<Customer> restaurantQueue;
	
	public PatRestaurant(Customer[] customers){
		super(customers);
		restaurantQueue = new SLLRestaurantQueue<Customer>();
	}
	
	@Override
	public void takeNewOrder() {
		
		System.out.println("Taking new order.");
		if(wait==0 && restaurantQueue.size()>0) {
			// TODO Auto-generated method stub
			Customer customerAttended = restaurantQueue.dequeue();
			addToProfit(customerAttended.getCostOfOrder());
			setWait(customerAttended.getTimeToPrepare());
			System.out.println(customerAttended.getId());
			System.out.println(customerAttended.getTimeToPrepare());
			customersInRestaurant--;
		}
		
	}

	
	@Override
	public void updateCustomerStatus() {
		System.out.println("Updating customers status.");

		// TODO Auto-generated method stub
		
		boolean foundNewCustomer = false;

		do{
			if(restaurantQueue.first()==null){
				foundNewCustomer=true;
			}
			else{
				Customer tmpCustomer = restaurantQueue.first();
				if(tmpCustomer.getPatience() + tmpCustomer.getArrival() < currentTurn){
					restaurantQueue.dequeue();
					customersInRestaurant--;
					unsatisfiedCustomers++;
				}else{
					foundNewCustomer = true;
				}
			}
		}while(!foundNewCustomer);
		
	}


	@Override
	public void receiveCustomers() {
		System.out.println("Receiving customers.");
		// TODO Auto-generated method stub
		for(int i=0; i<customers.length; i++){
			if(customers[i].getArrival()==currentTurn){
				restaurantQueue.enqueue(customers[i]);
				customersInRestaurant++;
				System.out.println(customers[i].getId());
			}
		}	
	}
	


}

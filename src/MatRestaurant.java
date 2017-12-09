import java.util.ArrayList;

public class MatRestaurant extends Restaurant {

	private SLLRestaurantStack<Customer> customerLine;
	
	public MatRestaurant(ArrayList<Customer> customers) {
		super(customers);
		customerLine = new SLLRestaurantStack<Customer>();
	}

	@Override
	public void takeNewOrder() {
		if(this.getWait() == 0 && customerLine.size()>0) {
			this.addToProfit(customerLine.top().getCostOfOrder());
			this.setWait(customerLine.pop().getTimeToPrepare());
			customersInRestaurant--;
		}
	}

	@Override
	public void updateCustomerStatus() {
		Boolean takeOrder = false;
		
		
		
		do {
			if(customerLine.top() == null) {
				takeOrder = true;

			}
			else {
				
				if((customerLine.top().getArrival() + customerLine.top().getPatience()) <= this.getCurrentTurn()) {
					customerLine.pop();
					customersInRestaurant--;
					unsatisfiedCustomers++;
				}
				else {
					takeOrder = true;
				}
			}
			
				
		}while(!takeOrder);
		
	}

	@Override
	public boolean isKitchenAvailable() {
		return this.getWait()==0;
	}


	@Override
	public void receiveCustomers() {
		ArrayList<Customer> customerList = this.getCustomers();
		for(int i = 0;i<customerList.size();i++) {
			if(this.getCurrentTurn() == customerList.get(i).getArrival()) {
				customerLine.push(customerList.get(i));
				customersInRestaurant++;
				interactionCounter++;
			}
		}
		
	}
	
	
	
}

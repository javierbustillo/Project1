
public class MatRestaurant extends Restaurant {

	private SLLRestaurantStack<Customer> customerLine;
	
	public MatRestaurant(Customer[] customers) {
		super(customers);
		customerLine = new SLLRestaurantStack<Customer>();
	}

	@Override
	public void takeNewOrder() {
		if(this.getWait() == 0 && customerLine.size()>0) {
			this.addToProfit(customerLine.top().getCostOfOrder());
			this.setWait(customerLine.pop().getTimeToPrepare());
			this.setCustomersInRestaurant(this.getCustomersInRestaurant()-1);
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
					this.setCustomersInRestaurant(this.getCustomersInRestaurant()-1);
					this.setUnsatisfiedCustomers(this.getUnsatisfiedCustomers()+1);
				}
				else {
					takeOrder = true;
				}
			}
			
				
		}while(!takeOrder);
		
	}

	@Override
	public Boolean isKitchenAvailable() {
		return this.getWait()==0;
	}

	@Override
	public void receiveCustomers() {
		Customer [] customerList = this.getCustomers();
		for(int i = 0;i<customerList.length;i++) {
			if(this.getCurrentTurn() == customerList[i].getArrival()) {
				customerLine.push(customerList[i]);
				this.setCustomersInRestaurant(this.getCustomersInRestaurant()+1);
				System.out.println(customerLine.top().getId());
			}
		}
		
	}
	
	
	
}

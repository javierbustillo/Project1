import java.util.ArrayList;

public class MaxRestaurant extends Restaurant {

	ArrayList<Customer> customersInLine;
	public MaxRestaurant(Customer[] customers) {
		super(customers);
		customersInLine = new ArrayList<Customer>();
	}
	
	@Override
	public void takeNewOrder() {
		if(this.getWait() == 0 && customersInLine.size()>0) {
			int indexOfMax=0;
			double maxProfit = customersInLine.get(0).getCostOfOrder();
			Customer maxCustomer = customersInLine.get(0);
			for(int i=0;i<customersInLine.size();i++) {
				if(maxProfit<customersInLine.get(i).getCostOfOrder()) {
					maxProfit = customersInLine.get(i).getCostOfOrder();
					maxCustomer = customersInLine.get(i);
					indexOfMax = i;
				}
			}
			if(maxCustomer.equals(customersInLine.get(0))) {
				customersInLine.remove(0);
			}
			else {
				customersInLine.remove(indexOfMax);
			}
			this.addToProfit(maxCustomer.getCostOfOrder());
			this.setWait(maxCustomer.getTimeToPrepare());
			this.setCustomersInRestaurant(this.getCustomersInRestaurant()-1);

		}
		
		
	}

	@Override
	public void updateCustomerStatus() {
		for(int i=0;i<customersInLine.size();i++) {
			if((customersInLine.get(i).getArrival() + customersInLine.get(i).getPatience()) <= this.getCurrentTurn()) {
				customersInLine.remove(i);
				this.setCustomersInRestaurant(this.getCustomersInRestaurant()-1);
				this.setUnsatisfiedCustomers(this.getUnsatisfiedCustomers()+1);
				i=-1;
			}
		}
	}

	@Override
	public boolean isKitchenAvailable() {
		return this.getWait() == 0;
	}

	@Override
	public void receiveCustomers() {
		Customer [] customerList = this.getCustomers();
		for(int i=0;i<customerList.length;i++) {
			if(this.getCurrentTurn() == customerList[i].getArrival()) {
				customersInLine.add(customerList[i]);
				this.setCustomersInRestaurant(this.getCustomersInRestaurant()+1);
				interactionCounter++;
			}
		}

	}
		
}



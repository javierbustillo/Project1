import java.util.ArrayList;

public class PacRestaurant extends Restaurant {
	
	ArrayList<Customer> customersInLine;

	public PacRestaurant(ArrayList<Customer> customers) {
		super(customers);
		customersInLine = new ArrayList<Customer>();
	}
	

	@Override
	public void takeNewOrder() {
		// TODO Auto-generated method stub
		if(customersInLine.size()>0&&wait==0){
			int customerSelectedIndex = 0;
			for(int i=0; i<customersInLine.size(); i++){
				if(customersInLine.get(i).getTimeToPrepare()<customersInLine.get(customerSelectedIndex).getTimeToPrepare()){
					customerSelectedIndex = i;
				}
			}
			setWait(customersInLine.get(customerSelectedIndex).getTimeToPrepare());
			addToProfit(customersInLine.get(customerSelectedIndex).getCostOfOrder());
			customersInLine.remove(customerSelectedIndex);
			customersInRestaurant--;
		}
	}
	
	
	@Override
	public void updateCustomerStatus() {
		// TODO Auto-generated method stub
		while(!customersInLine.isEmpty()&&customersInLine.get(0).getArrival()+customersInLine.get(0).getPatience()<currentTurn){
			customersInLine.remove(0);
			unsatisfiedCustomers++;
			customersInRestaurant--;
		}
	}

	@Override
	public void receiveCustomers() {
		// TODO Auto-generated method stub
		for(int i=interactionCounter; i<customers.size()&&customers.get(i).getArrival()<=currentTurn; i++){
			customersInLine.add(customers.get(i));
			customersInRestaurant++;
			interactionCounter++;	
		}	
	}

}

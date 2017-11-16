
public class Customer {
	// instance variables
	private int arrival;
	private String id;
	private int timeToPrepare;
	private int costOfOrder;
	private int patience;
	private Boolean satisfied;
	
	public Customer(int arrival, String id, int timeToPrepare, int costOfOrder, int patience) {
		this.arrival = arrival;
		this.id = id;
		this.timeToPrepare = timeToPrepare;
		this.costOfOrder = costOfOrder;
		this.patience = patience;
	}
	
	public int getArrival() {
		return arrival;
	}
	
	public String getId() {
		return id;
	}
	
	public int getTimeToPrepare() {
		return timeToPrepare;
	}
	
	public int getCostOfOrder() {
		return costOfOrder;
	}
	
	public int getPatience() {
		return patience;
	}
	
	public Boolean getSatisfied() {
		return satisfied;
	}
	
	public void setSatisfied(Boolean satisfied) {
		this.satisfied = satisfied;
	}
	

}

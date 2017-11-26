
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Customer[] customers = new Customer[5];
		customers[0] = new Customer(1, "451263", 10, 2.30, 15);
		customers[1] = new Customer(2, "540909", 2, 5.00, 10);
		customers[2] = new Customer(2, "909028", 5, 1.20,7);
		customers[3] = new Customer(2, "123654", 10, 11.00, 15);
		customers[4] = new Customer(4, "541739", 10, 2.3, 20);
		
		PatRestaurant firstTry = new PatRestaurant(customers);
		
		firstTry.simulate();
		
		System.out.println(firstTry.getProfit());
		System.out.println(firstTry.getUnsatisfiedCustomers());
		System.out.println(firstTry.getCurrentTurn());

	}

}

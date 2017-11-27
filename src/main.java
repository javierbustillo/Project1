
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Customer[] customers = new Customer[5];
		customers[0] = new Customer(1, "451263", 10, 2.30, 15);
		customers[1] = new Customer(2, "540909", 2, 5.00, 10);
		customers[2] = new Customer(2, "909028", 5, 1.20,7);
		customers[3] = new Customer(2, "123654", 10, 11.00, 15);
		customers[4] = new Customer(4, "541739", 10, 2.3, 20);
		
		System.out.println("\nPat's Restaurant");
		PatRestaurant patRestaurant = new PatRestaurant(customers);
		patRestaurant.simulate();
		System.out.println(patRestaurant.getProfit());
		System.out.println(patRestaurant.getUnsatisfiedCustomers());
		System.out.println(patRestaurant.getCurrentTurn());
		
		System.out.println("\nMat's Restaurant");
		MatRestaurant matRestaurant = new MatRestaurant(customers);
		matRestaurant.simulate();
		System.out.println(matRestaurant.getProfit());
		System.out.println(matRestaurant.getUnsatisfiedCustomers());
		System.out.println(matRestaurant.getCurrentTurn());
		
		System.out.println("\nMax's Restaurant");
		MaxRestaurant maxRestaurant = new MaxRestaurant(customers);
		maxRestaurant.simulate();
		System.out.println(maxRestaurant.getProfit());
		System.out.println(maxRestaurant.getUnsatisfiedCustomers());
		System.out.println(maxRestaurant.getCurrentTurn());
		
		System.out.println("\nPac's Restaurant");
		PacRestaurant pacRestaurant = new PacRestaurant(customers);
		pacRestaurant.simulate();
		System.out.println(pacRestaurant.getProfit());
		System.out.println(pacRestaurant.getUnsatisfiedCustomers());
		System.out.println(pacRestaurant.getCurrentTurn());
		

	}

}

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;
import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Customer> customersInLine = new ArrayList<Customer>();
		

		JFileChooser jfc = new JFileChooser();
		jfc.showDialog(null, "Choose file");
		jfc.setVisible(true);
		
		File fileName = jfc.getSelectedFile();
		
		String fileType = fileName.getPath().substring(fileName.getPath().length()-3);
		System.out.println(fileType);

		if(fileType.equals("txt")){
			ArrayList<String> inputs = new ArrayList<String>();
			inputs = txtReader(fileName.getPath());
			for(int i = 0;i<inputs.size();i++){
				customersInLine = customerReader(fileName.getParent()+"/"+inputs.get(i));
				output(customersInLine);
			}
		}
		else{
			customersInLine = customerReader(fileName.getPath());
			output(customersInLine);

			
		}
		
	}
		
		
	private static ArrayList<Customer> customerReader(String path){
		ArrayList<Customer> customersInLine = new ArrayList<Customer>();
		String line;
		try (BufferedReader reader = new BufferedReader(new FileReader(path))){
				
			while((line = reader.readLine()) != null){
				String[] s = line.split(",");
		
				int arrival = Integer.parseInt(s[0]);
				String id = s[1];
				int timeToPrepare = Integer.parseInt(s[2]);
				double costOfOrder = Double.parseDouble(s[3].substring(1));
				int patience = Integer.parseInt(s[4]);
				System.out.println(costOfOrder);

				customersInLine.add(new Customer(arrival, id, timeToPrepare, costOfOrder, patience));
					
			}
		}
		catch(IOException e){
				
		}
		return customersInLine;
	}
	
	private static ArrayList<String> txtReader(String path){
		String line;
		ArrayList<String> inputs = new ArrayList<String>();
		try (BufferedReader reader = new BufferedReader(new FileReader(path))){
			
			while((line = reader.readLine()) != null){
				inputs.add(line);
			}
		}
		catch(IOException e){
				
		}
		
		return inputs;
		
	}
	
	private static void output(ArrayList<Customer> customersInLine){
		PatRestaurant pat = new PatRestaurant(customersInLine);
		MatRestaurant mat = new MatRestaurant(customersInLine);
		MaxRestaurant max = new MaxRestaurant(customersInLine);
		PacRestaurant pac = new PacRestaurant(customersInLine);
		
		pat.simulate();
		mat.simulate();
		max.simulate();
		pac.simulate();
		
		System.out.println("Pat's approach profit: " + pat.getProfit());
		System.out.println("Pat's approach number of disappointed customers: " + pat.getUnsatisfiedCustomers());
		System.out.println("Mat's approach profit: " + mat.getProfit());
		System.out.println("Mat's approach number of disappointed customers: " + mat.getUnsatisfiedCustomers());
		System.out.println("Max's approach profit: " + mat.getProfit());
		System.out.println("Max's approach number of disappointed customers: " + mat.getUnsatisfiedCustomers());
		System.out.println("Pac's approach profit: " + pac.getProfit());
		System.out.println("Pac's approach number of disappointed customers: " + pac.getUnsatisfiedCustomers());
	}
		
}

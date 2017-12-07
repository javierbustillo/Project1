import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;
import java.util.ArrayList;

public class main {

	static ArrayList<Customer> customersInLine = new ArrayList<Customer>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		File fileName = new File("input.txt");
		
		ArrayList<String> inputs = new ArrayList<String>();
		inputs = txtReader(fileName.getPath());
		
		for(int i = 0;i<inputs.size();i++){
			customersInLine = customerReader(inputs.get(i));
			output(customersInLine, inputs.get(i));
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
	
	private static double maximumProf(ArrayList<Customer> customers) {
		double max = 0;
		for(int i=0;i<customers.size();i++) {
			max+=customers.get(i).getCostOfOrder();
		}
		return max;
	}
	
	private static void output(ArrayList<Customer> customersInLine, String inputFileString) throws IOException{
		PatRestaurant pat = new PatRestaurant(customersInLine);
		MatRestaurant mat = new MatRestaurant(customersInLine);
		MaxRestaurant max = new MaxRestaurant(customersInLine);
		PacRestaurant pac = new PacRestaurant(customersInLine);
		
		pat.simulate();
		mat.simulate();
		max.simulate();
		pac.simulate();

		double maxCustomers = customersInLine.size();
		double maxProfit = maximumProf(customersInLine);
		
		
		String maximumProfits = "Maximum profit possible: $" + String.format("%.2f", maxProfit);
		String maximumCustomers = "Maximum number of customers served possible: "+ String.format("%.0f", maxCustomers) ;
		
		String patStringProfit = "Pat's approach profit: $" + String.format("%.2f", pat.getProfit());
		String patStringCustomers = "Pat's approach number of disappointed customers: " + pat.getUnsatisfiedCustomers();
		
		String matStringProfit = "Mat's approach profit: $" + String.format("%.2f", mat.getProfit());
		String matStringCustomers = "Mat's approach number of disappointed customers: " + mat.getUnsatisfiedCustomers();
		
		String maxStringProfit = "Max's approach profit: $" + String.format("%.2f", max.getProfit());
		String maxStringCustomers = "Max's approach number of disappointed customers: " + max.getUnsatisfiedCustomers();

		String pacStringProfit = "Pac's approach profit: $" + String.format("%.2f", pac.getProfit());
		String pacStringCustomers = "Pac's approach number of disappointed customers: " + pac.getUnsatisfiedCustomers();
	
		String outputContent = maximumProfits + "\n" + maximumCustomers + "\n" + patStringProfit + "\n" + patStringCustomers + "\n" + matStringProfit +"\n" + matStringCustomers + "\n" + maxStringProfit + "\n" + maxStringCustomers + "\n" + pacStringProfit + "\n" + pacStringCustomers;
		
		String fileName = inputFileString.substring(0, inputFileString.length()-4);
		
		Path outputPath = Paths.get(fileName+".out");
		
		Files.write(outputPath, outputContent.getBytes());
		
	}
		
}

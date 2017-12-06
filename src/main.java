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


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<Customer> customersInLine = new ArrayList<Customer>();
		

		JFileChooser jfc = new JFileChooser();
		jfc.showDialog(null, "Choose file");
		jfc.setVisible(true);
		
		File fileName = jfc.getSelectedFile();
		
		String fileType = fileName.getPath().substring(fileName.getPath().length()-3);

		if(fileType.equals("txt")){
			ArrayList<String> inputs = new ArrayList<String>();
			inputs = txtReader(fileName.getPath());
			for(int i = 0;i<inputs.size();i++){
				customersInLine = customerReader(fileName.getParent()+"/"+inputs.get(i));
				output(customersInLine, inputs.get(i), fileName);
			}
		}
		else{
			customersInLine = customerReader(fileName.getPath());
			output(customersInLine,fileName.getName(), fileName);

			
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
	
	private static double maximum(double[] profits) {
		double max = profits[0];
		for(int i=0;i<profits.length;i++) {
			if(max<profits[i]) {
				max = profits[i];
			}
		}
		return max;
	}
	
	private static void output(ArrayList<Customer> customersInLine, String inputFileString, File inputFile) throws IOException{
		PatRestaurant pat = new PatRestaurant(customersInLine);
		MatRestaurant mat = new MatRestaurant(customersInLine);
		MaxRestaurant max = new MaxRestaurant(customersInLine);
		PacRestaurant pac = new PacRestaurant(customersInLine);
		
		pat.simulate();
		mat.simulate();
		max.simulate();
		pac.simulate();
		
		double[] profits = new double[4];
		profits[0] = pat.getProfit();
		profits[1] = mat.getProfit();
		profits[2] = max.getProfit();
		profits[3] = pac.getProfit();
		
		double[] customersServed = new double[4];
		customersServed[0] = pat.getCustomers().size() - pat.getUnsatisfiedCustomers();
		customersServed[1] = mat.getCustomers().size() - mat.getUnsatisfiedCustomers();
		customersServed[2] = max.getCustomers().size() - max.getUnsatisfiedCustomers();
		customersServed[3] = pac.getCustomers().size() - pac.getUnsatisfiedCustomers();

		double maxCustomers = maximum(customersServed);
		double maxProfit = maximum(profits);
		
		
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
		
		String outputPathString = inputFile.getParent()+"/"+fileName+".out";
		System.out.println(fileName);
		
		Path inputPath = Paths.get(outputPathString);
		Path dirPath = Paths.get(inputFile.getParent());
		Path fullPath = dirPath.resolve(inputPath);
		
		Files.write(fullPath, outputContent.getBytes());
		System.out.println(fullPath.toString());
		
		
	}
		
}

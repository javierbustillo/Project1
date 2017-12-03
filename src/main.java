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
		

		JFileChooser jfc = new JFileChooser();
		jfc.showDialog(null, "Choose file");
		jfc.setVisible(true);
		Scanner scan = null;
		String line;
		ArrayList<Customer> customersInLine = null;

		
		File filename = jfc.getSelectedFile();
		
		try (BufferedReader reader = new BufferedReader(new FileReader("/Users/Javdav/Documents/ICOM 4035/Programs/L6_QueueLab_2017 Student/input4.csv"))){

			while((line = reader.readLine()) != null){
				String[] s = line.split(",");

				int arrival = Integer.parseInt(s[0]);
				String id = s[1];
				int timeToPrepare = Integer.parseInt(s[2]);
				double costOfOrder = Double.parseDouble(s[3]);
				int patience = Integer.parseInt(s[4]);

				customersInLine.add(new Customer(arrival, id, timeToPrepare, costOfOrder, patience));
				
			}
		}
		catch(IOException e){
			
		}
		
		
	

	}

}

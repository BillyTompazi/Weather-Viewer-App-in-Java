
import java.awt.Desktop;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class WriteFile {
	
	/********************************************
	 * Loops an array with weather stations names
	 * and the tableview calculates the Max and
	 * Min temperatures, the average af and
	 * rain
	 * @param TableView<Record> tableView 
	 * @param TableColumn<Record, String> columnTmax
	 * @param TableColumn<Record, String> columnTmin
	 * @param TableColumn<Record, String> columnAf
	 * @param TableColumn<Record, String> columnRain
	 * @param String name
	 * *****************************************/
	 public void writeFile(TableView<Record> tableView, TableColumn<Record, String> columnTmax, TableColumn<Record, String> columnTmin, TableColumn<Record, String> columnAf, 
			 TableColumn<Record, String> columnRain, String name) throws IOException {
		 //Array with Station Names
	    	String[] stationNames = {"Stations","Aberporth", "Armagh", "Ballypatrick Forest", "Bradford", "Braemar", "Camborne", "Cambridge NIAB", "Cardiff Bute Park", 
	        		"Chivenor", "Dunstaffnage", "Durham", "Eastbourne", "Eskdalemuir", "Heathrow", "Hurn", "Lerwick", "Leuchars", "Lowestoft", "Manston", 
	        		"Nairn", "Newton Rigg", "Oxford", "Paisley", "Ross-on-Wye", "Shawbury", "Sheffield", "Stornoway Airport", "Sutton Bonington", "Tiree",
	        		"Valley", "Waddington", "Whitby", "Wick Airport", "Yeovilton"};
	    	//Initialize variables
	        	 int number = 0;
		         double maxTemp = 0;
		         double minTemp = 50;
		         double sumAf = 0;
		         double averageAf = 0;
		         double sumRain = 0;
		         double averageRain = 0;
		         
		       //Loop the stations array to get the index of each station
			      for(int i = 0; i < stationNames.length; i++) {
			    		if(stationNames[i].equals(name)) {
			    			number = i;
					    }
			    	}
		         
		   	for (int i = 0; i < tableView.getItems().size(); i++) {
		   		
		   		double maxTempTmax = Double.parseDouble((String) columnTmax.getCellData(i));
		   		
		   		//Finds max temperature
		   		if(maxTempTmax > maxTemp) { 
		   			maxTemp = maxTempTmax;
		   		} 
		   		
		   		double maxTempTmin = Double.parseDouble((String) columnTmin.getCellData(i));
		   		
		   	    //Finds min temperature
		   		if(maxTempTmin < minTemp) { 
		   			minTemp = maxTempTmin;
		   		} 
		   		
		   		double Af = Double.parseDouble((String) columnAf.getCellData(i));
		   		//Sum of af
		   		sumAf = sumAf + Af;
		   		
		   		double rain = Double.parseDouble((String) columnRain.getCellData(i));
		   		//Sum of rain
		   		sumRain = sumRain + rain;
		   	}
		   	
		   	//Average of af
		   	averageAf = sumAf / tableView.getItems().size();
		   	//Average of rain
		   	averageRain = sumRain / tableView.getItems().size();
		   	
		    

		      //Create new file
		      File file = new File("WeatherReport.txt");
			      
			  // creates the file
			  file.createNewFile();
			      
			  // creates a FileWriter Object
			  FileWriter writer = new FileWriter(file);
			     
			  //Write inside the file   
			  writer.write("Number: " + number);
			  writer.write(System.lineSeparator());    
			  writer.write("Station: " + name);
			  writer.write(System.lineSeparator());    
		      writer.write("Highest: " + maxTemp);
		      writer.write(System.lineSeparator()); //new line
		      writer.write("Lowest: " + minTemp);
		      writer.write(System.lineSeparator()); //new line
		      writer.write("Average annual af: " + averageAf);
		      writer.write(System.lineSeparator()); //new line
		      writer.write("Average annual rainfall: " + averageRain);

		      writer.flush();
		      writer.close();

		      // Creates a FileReader Object
		      FileReader fr = new FileReader(file); 
		      char [] a = new char[50];
		      fr.read(a);   // reads the content to the array
		      
		      fr.close();
		   
		   	Desktop desktop = Desktop.getDesktop();
		   	desktop.open(file);
	    }
}

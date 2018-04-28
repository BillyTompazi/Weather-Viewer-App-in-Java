import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class ReadCSV {
	
	/*****************************************
	 * Reads the CSV files
	 * @param String name,
	 * @param TableView<Record> tableView
	 * @param ObservableList<Record> dataList
	 * **************************************/
	  public void readCSV(String name, TableView<Record> tableView, ObservableList<Record> dataList) {
		  //Loops the tableView and clears the data every
		  //time a new content is loaded
	    	for ( int i = 0; i<tableView.getItems().size(); i++) {
	    	    tableView.getItems().clear();
	    	}
	    	
	   				String CsvFile ="C:\\Users\\billy\\Desktop\\Java Assignment\\data";
			        CsvFile += "\\"+name+".csv";
			        String FieldDelimiter = ",";
			        
			 
			        BufferedReader br;
			        
			        try {
			            br = new BufferedReader(new FileReader(CsvFile));
			 
			            String line;
			            while ((line = br.readLine()) != null) {
			                String[] fields = line.split(FieldDelimiter, -1);
			 
			                Record record = new Record(fields[0], fields[1], fields[2],
			                        fields[3], fields[4], fields[5]);
			                dataList.add(record);
			 
			            }
			 
			        } catch (FileNotFoundException ex) {
			            Logger.getLogger(Main.class.getName())
			                    .log(Level.SEVERE, null, ex);
			        } catch (IOException ex) {
			            Logger.getLogger(Main.class.getName())
			                    .log(Level.SEVERE, null, ex);
			        }

	 		}
}

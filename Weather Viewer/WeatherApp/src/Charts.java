import java.util.ArrayList;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Charts {
	/***********************************
	 * It loops 9 times and Renders the
	 *  Average Tmax nad Tmin 
	 * data on the lineChart
	 * and in this method the 
	 * readTableData gets called
	 * @param XYChart.Series series,   
	 * @param TableColumn<Record
	 * @param String> column
	 * @param String name
	 * @param TableView<Record> tableview
	 * @return  temp
	 * ********************************/
	boolean printChart(XYChart.Series<String, String> series, TableColumn<Record, String> column, Object newValue, TableView tableview) {
    	series.getData().clear();
    	 int year = 2009;
    	 boolean temp = false;
    	 int startMonth = 1;
    	 int endMonth = 12;
    	for(int i = 0; i < 9; i++) {
    		temp = series.getData().add(new XYChart.Data(year, readTableData(startMonth, endMonth, column, tableview)));
    		year = year + 1;
    		startMonth = startMonth + 12;
    		endMonth = endMonth + 12;
    	}
    	return temp;
				    	
    }
    
	/****************************************************
	 * It loops 9 times and Renders air frost data on 
	 * the pieChart and in this method
	 * the readTableData gets called
	 * @param ObservableList<PieChart.Data> pieChartData,   
	 * @param TableColumn<Record
	 * @param String> column
	 * @param String name
	 * @param TableView<Record> tableview
	 * @return af
	 * **************************************************/
	boolean printPieChart( ObservableList<PieChart.Data> pieChartData, TableColumn<Record, String> column, String name, TableView<Record> tableview, PieChart pieChart) {
		pieChartData.clear();
    	 int year = 2009;
    	 boolean af = false ;
    	 int startMonth = 1;
    	 int endMonth = 12;
    	
    	for(int i = 0; i < 9; i++) {
    		String convertYear = Integer.toString(year);
    		af =  pieChartData.addAll(new PieChart.Data(convertYear, readTableDataRain(startMonth, endMonth, column, tableview)));
    		//af = series.getData().add(new XYChart.Data(year, readTableData(startMonth, endMonth, column, tableview)));
    		year = year + 1;
    		startMonth = startMonth + 12;
    		endMonth = endMonth + 12;
    	}
    	return af;
				    	
    }
	
	/***********************************************
	 * It loops 9 times and Renders Max temperatures 
	 * of each year data 
	 * on the lineChart
	 * and in this method the 
	 * readTableDataMaxTemp gets called
	 * @param XYChart.Series series,   
	 * @param TableColumn<Record
	 * @param String> column
	 * @param String name
	 * @param TableView<Record> tableview
	 * @return temp
	 * ********************************************/
	boolean printChartMaxTemp(XYChart.Series<String, String> series, TableColumn<Record, String> column, String name, TableView<Record> tableview) {
    	series.getData().clear();
    	 int year = 2009;
    	 boolean temp = false;
    	 int startMonth = 1;
    	 int endMonth = 12;
    	for(int i = 0; i < 9; i++) {
    		temp = series.getData().add(new XYChart.Data(year, readTableDataMaxTemp(startMonth, endMonth, column, tableview)));
    		year = year + 1;
    		startMonth = startMonth + 12;
    		endMonth = endMonth + 12;
    	}
    	return temp;
				    	
    }
	
	/***********************************************
	 * It loops 9 times and Renders Min temperatures 
	 * of each year data on the lineChart
	 * and in this method the 
	 * readTableDataMinTemp gets called
	 * @param XYChart.Series series,   
	 * @param TableColumn<Record
	 * @param String> column
	 * @param String name
	 * @param TableView<Record> tableview
	 * @return temp
	 * ********************************************/
	boolean printChartMinTemp(XYChart.Series<String, String> series, TableColumn<Record, String> column, String name, TableView<Record> tableview) {
    	series.getData().clear();
    	 int year = 2009;
    	 boolean temp = false;
    	 int startMonth = 1;
    	 int endMonth = 12;
    	for(int i = 0; i < 9; i++) {
    		temp = series.getData().add(new XYChart.Data(year, readTableDataMinTemp(startMonth, endMonth, column, tableview)));
    		year = year + 1;
    		startMonth = startMonth + 12;
    		endMonth = endMonth + 12;
    	}
    	return temp;
				    	
    }
	
	/*******************************************
	 * It loops 9 times and Renders average 
	 * rainfall of each year data 
	 * on the barChart and in this method the 
	 * readTableDataRain gets called
	 * @param XYChart.Series series,   
	 * @param TableColumn<Record
	 * @param String> column
	 * @param String name
	 * @param TableView<Record> tableview
	 * @return rain
	 * ****************************************/
	 boolean printBarChart(XYChart.Series series, TableColumn<Record, String> column, String name, TableView<Record> tableview) {
	    	series.getData().clear();
	    	 int year = 2009;
	    	 boolean rain = false;
	    	 int startMonth = 1;
	    	 int endMonth = 12;
	    	for(int i = 0; i < 9; i++) {
	    		String convertYear = Integer.toString(year);
	    		rain = series.getData().add(new XYChart.Data<>(convertYear, readTableDataRain(startMonth, endMonth, column, tableview)));
	    		year = year + 1;
	    		startMonth = startMonth + 12;
	    		endMonth = endMonth + 12;
	    	}
	    	return rain;
					    	
	    }
	
	
	/*******************************************
	* Reads tableData and calculates the average
	* temp inside the range of the sublist in our 
	* example the range is 1-12 (12 months) and it
	* continues to the next sublist
	* @paramint start
	* @param int end
	* @param TableColumn<Record, String> column
	* @param TableView<Record> tableview
	* @return tempAverage
	* ****************************************/
    double readTableData(int start, int end, TableColumn<Record, String> column, TableView<Record> tableview) {
    	 //Create an ArrayList for the tableview
        List<Record> temp = new ArrayList<>();
         temp = tableview.getItems(); 
         //Create a sublist from the tableView
         List<Record> subTemp = temp.subList(start, end);
         double tempSum = 0;
         double tempAverage = 0;
   	for (Record o : subTemp ) {
   		
   		double maxTemp = Double.parseDouble((String) column.getCellData(o));
   		tempSum = tempSum + maxTemp;
   		tempAverage = tempSum / 12;
   		
      	}
	return tempAverage;
    }
    
    /*******************************************
	* Reads tableData and finds the max
	* temp inside the range of the sublist in our 
	* example the range is 1-12 (12 months) and it
	* continues to the next sublist
	* @param int start
	* @param int end
	* @param TableColumn<Record, String> column
	* @param TableView<Record> tableview
	* @return maxTemp
	* ****************************************/
    double readTableDataMaxTemp(int start, int end, TableColumn<Record, String> column, TableView<Record> tableview) {
   	 //Create an ArrayList for the tableview
       List<Record> temp = new ArrayList<>();
        temp = tableview.getItems(); 
        //Create a sublist from the tableView
        List<Record> subTemp = temp.subList(start, end);
       
        double maxTemp = 0;
  	for (Record o : subTemp ) {
  		
  		double maxTempMax = Double.parseDouble((String) column.getCellData(o));
  		if(maxTempMax > maxTemp) { 
   			maxTemp = maxTempMax;
      		} 
  		
     	}
  	
	return maxTemp;
   }
    
    /*******************************************
   	* Reads tableData and finds the min
   	* temp inside the range of the sublist in our 
   	* example the range is 1-12 (12 months) and it
   	* continues to the next sublist
   	* @param int start
   	* @param int end
   	* @param TableColumn<Record, String> column
   	* @param TableView<Record> tableview
   	* @return minTemp
   	* ****************************************/
    double readTableDataMinTemp(int start, int end, TableColumn<Record, String> column, TableView<Record> tableview) {
   	 //Create an ArrayList for the tableview
       List<Record> temp = new ArrayList<>();
        temp = tableview.getItems(); 
        //Create a sublist from the tableView
        List<Record> subTemp = temp.subList(start, end);
       
        double minTemp = 50;
  	for (Record o : subTemp ) {
  		
  		double minTempTmin = Double.parseDouble((String) column.getCellData(o));
   		
   		if(minTempTmin < minTemp) { 
   			minTemp = minTempTmin;
   		} 
  		
     	}
  	
	return minTemp;
   }
    
    
    /*******************************************
   	* Reads tableData and finds the average
   	* rain inside the range of the sublist in our 
   	* example the range is 1-12 (12 months) and it
   	* continues to the next sublist
   	* @param int start
   	* @param int end
   	* @param TableColumn<Record, String> column
   	* @param TableView<Record> tableview
   	* @return totalRain
   	* ****************************************/
    double readTableDataRain(int start, int end, TableColumn<Record, String> column, TableView<Record> tableview) {
   	 //Create an ArrayList for the tableview
       List<Record> rain = new ArrayList<>();
        rain = tableview.getItems(); 
        //Create a sublist from the tableView
        List<Record> subTemp = rain.subList(start, end);
        double totalRain = 0;
        //double tempAverage = 0;
  	for (Record o : subTemp ) {
  		
  		double rainSum = Double.parseDouble((String) column.getCellData(o));
  		totalRain= totalRain + rainSum;
  		
     	}
	return totalRain;
   }

    
}

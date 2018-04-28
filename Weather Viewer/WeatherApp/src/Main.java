import java.io.IOException;
import java.util.Arrays;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart; 
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.application.Application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{
	
	//TableView
	private final TableView<Record> tableView = new TableView<>();
	
	 //ObservableList
    public final ObservableList<Record> dataList
            = FXCollections.observableArrayList();

 
    @SuppressWarnings("unchecked")
	@Override
    public void start(Stage primaryStage) {
    	
        primaryStage.setTitle("Weather Viewer");
 
        /****************
         * Table Columns
         * *************/
        TableColumn<Record, String> columnF1 = new TableColumn<Record, String>("Year");
        columnF1.setCellValueFactory(
                new PropertyValueFactory<Record, String>("year"));
 
        TableColumn<Record, String>  columnF2 = new TableColumn<Record, String>("Month");
        columnF2.setCellValueFactory(
                new PropertyValueFactory<Record, String>("month"));
 
        TableColumn<Record, String>  columnF3 = new TableColumn<Record, String>("TMax");
        columnF3.setCellValueFactory(
                new PropertyValueFactory<Record, String>("tmax"));
 
        TableColumn<Record, String>  columnF4 = new TableColumn<Record, String>("TMin");
        columnF4.setCellValueFactory(
                new PropertyValueFactory<Record, String>("tmin"));
 
        TableColumn<Record, String>  columnF5 = new TableColumn<Record, String>("AF");
        columnF5.setCellValueFactory(
                new PropertyValueFactory<Record, String>("af"));
 
        TableColumn<Record, String>  columnF6 = new TableColumn<Record, String>("Rain");
        columnF6.setCellValueFactory(
                new PropertyValueFactory<Record, String>("rain"));
 
        tableView.setItems(dataList);
        tableView.getColumns().addAll(
                columnF1, columnF2, columnF3, columnF4, columnF5, columnF6);
        

       
        
        /*********************
         Create Line Chart
        * ******************/        
      //Defining the x axis             
	      NumberAxis xAxis = new NumberAxis(2008, 2018, 1); 
	      xAxis.setLabel("Years"); 
	      
	        
	      //Defining the y axis   
	      NumberAxis yAxis = new NumberAxis   (-15, 35, 5); 
	      yAxis.setLabel("Temperatures in Celcius"); 
	        
	      //Creating the line chart 
	      @SuppressWarnings("rawtypes")
		  LineChart linechart = new LineChart(xAxis, yAxis);  
	      linechart.setTitle("Temperatures of Each Year");
	     
	        
	      //Prepare XYChart.Series objects by setting data 
	      
		XYChart.Series<String, String> series = new Series<String, String>(); 
	      series.setName("Average Max Temperatures");
	      
	      
		XYChart.Series<String, String> series2 = new Series<String, String>(); 
	      series2.setName("Average Min Temperatures");
	      
	      
		XYChart.Series<String, String> seriesMaxTemp = new Series<String, String>(); 
	      seriesMaxTemp.setName("Max Temperatures");
	      
	      
		XYChart.Series<String, String> seriesMinTemp = new Series<String, String>(); 
	      seriesMinTemp.setName("Min Temperatures");
	        
	            
	      //Setting the data to Line chart    
	      linechart.getData().addAll(series, series2, seriesMaxTemp, seriesMinTemp);       
          linechart.setLayoutX(90);
          linechart.setLayoutY(20);
          linechart.setMaxWidth(500);
          linechart.setMaxHeight(420);
         
        /*********************
        Create Pie Chart
        * ******************/         
        //Preparing ObservbleList object         
          ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        //Creating a Pie chart 
          PieChart pieChart = new PieChart(pieChartData);
        //Setting the title of the Pie chart 
          pieChart.setTitle("Total Air Frost Each Year");
        //setting the direction to arrange the data 
          pieChart.setClockwise(true);
        //Setting the length of the label line 
          pieChart.setLabelLineLength(40);
        //Setting the labels of the pie chart visible  
          pieChart.setLabelsVisible(true);
        //Setting the start angle of the pie chart 
          pieChart.setStartAngle(180);
          pieChart.setLayoutX(950);
          pieChart.setLayoutY(20);
          pieChart.setMaxHeight(420);
          pieChart.setMaxWidth(500);
          
          
          /*********************
          Create Bar Chart
          * ******************/  
        //Defining the axes              
          CategoryAxis axisX = new CategoryAxis();  
          axisX.setCategories(FXCollections.<String>
          observableArrayList(Arrays.asList("2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017")));
          
           
          NumberAxis axisY = new NumberAxis();
          axisY.setLabel("Amount of Rain");
         
          //Creating the Bar chart
          BarChart<String, Number> barChart = new BarChart<>(axisX, axisY); 
          barChart.setTitle("Total Amount of Rain Each Year");
            
          //Prepare XYChart.Series objects by setting data       
          XYChart.Series<String, Number> seriesRain = new XYChart.Series<>();
          seriesRain.setName("Rain");

          //Setting the data to bar chart       
          barChart.getData().addAll(seriesRain);
          
         // barChart.getData().addAll(seriesRain);
          barChart.setLayoutX(90);
          barChart.setLayoutY(380);
          barChart.setMaxHeight(320);
          //barChart.setMaxWidth(850);
         
        /******************
         * Create choicebox
         * ***************/
        ChoiceBox<String> choiceBox = new ChoiceBox<>();
          @SuppressWarnings("unused")
  		ChoiceBox<String> choiceBoxChartsReport = new ChoiceBox<>();
          
          /****************************************
           * Add weather stations names to checkbox
           * *************************************/
          choiceBox.getItems().addAll("Aberporth", "Armagh", "Ballypatrick Forest", "Bradford", "Braemar", "Camborne", "Cambridge NIAB", "Cardiff Bute Park", 
          		"Chivenor", "Dunstaffnage", "Durham", "Eastbourne", "Eskdalemuir", "Heathrow", "Hurn", "Lerwick", "Leuchars", "Lowestoft", "Manston", 
          		"Nairn", "Newton Rigg", "Oxford", "Paisley", "Ross-on-Wye", "Shawbury", "Sheffield", "Stornoway Airport", "Sutton Bonington", "Tiree",
          		"Valley", "Waddington", "Whitby", "Wick Airport", "Yeovilton");
          
          //Set width of choiceBox
          choiceBox.setPrefWidth(150);
          //Initial value of checkbox
          choiceBox.setValue("Aberporth");
          
          /************************************************
           * Create report button and call writeFile method
           * *********************************************/
          WriteFile callWriteFile = new WriteFile();
          Button reportButton = new Button();
          reportButton.setText("Report");
          reportButton.setOnAction(new EventHandler<ActionEvent>() {
              @Override
              public void handle(ActionEvent event) {
              	try {
          			callWriteFile.writeFile(tableView, columnF3, columnF4, columnF5, columnF6, choiceBox.getValue() );
          			
          		} catch (IOException e) {
          			e.printStackTrace();
          		}
                 
              }
          });
          
                 
        /**********************************************************
         * Create the map button and call the startMapWindow method
         * *******************************************************/
        //Create an instance of WeatherWIndow class         
        WeatherWindow  mapWindow = new WeatherWindow();
        //Create a button to open weather map
        Button mapButton = new Button("Show Weather Map");
        mapButton.setOnAction(e->{
        	
        	 VBox root2 = new VBox();
            
             root2.getChildren().addAll(mapWindow.startMapWindow());
           
             Scene secondScene = new Scene(root2, 1000,500);
             Stage secondStage = new Stage();
          // set the scene
             secondStage.setScene(secondScene); 
             
             secondStage.setTitle("Weather Map");
             secondStage.show();
        });
          
          
       /********************************************************
        * Add buttons to HBox in order to have horizontal layout
        * *****************************************************/
       HBox vBoxButtons = new HBox();
       vBoxButtons.getChildren().addAll( choiceBox, reportButton, mapButton );
       vBoxButtons.setSpacing(10);
       
       //Give buttons a css class
       choiceBox.getStyleClass().add("styleButtons");
       reportButton.getStyleClass().add("styleButtons");
       mapButton.getStyleClass().add("styleButtons");
       
       
       /*******************************
        * Create VBox for the tableVIew
        * in order to place it under 
        * the buttons
        * ****************************/
       VBox vBox = new VBox();
       vBox.setSpacing(10);
       vBox.getChildren().addAll( vBoxButtons,  tableView);
     
                     
        /*********************************
         * Create a VBox to add all charts
         * ******************************/
       VBox allChartsVBox = new VBox();
       allChartsVBox.getStyleClass().add("vbox");
       allChartsVBox.setId("vbox-custom");
        
       //Add 2 charts to HBox to align them horizontally
       HBox lineAndPieChart = new HBox();
       lineAndPieChart.getChildren().addAll(linechart, pieChart);
       
       // 2nd HBox for the 3d chart
       HBox barChartHBox = new HBox();
       barChartHBox.getChildren().add(barChart);
       
       //Add them all to allChartsVBox
       allChartsVBox.getChildren().addAll(lineAndPieChart, barChartHBox);
       allChartsVBox.setSpacing(10);
 
        
       /**************************
        * Adjust size of tableView
        * ***********************/
        //Set the width of each table column
        columnF1.setPrefWidth(70);
        columnF2.setPrefWidth(70);
        columnF3.setPrefWidth(70);
        columnF4.setPrefWidth(70);
        columnF5.setPrefWidth(60);
        columnF6.setPrefWidth(60);
        
        //Set the heigh of tableView
        tableView.setPrefHeight(680);
       
        
        /*****************************************************
         * Create Split Pane to break screen into to 2 parts
         * the tableView with the buttons and the charts area
         * **************************************************/
        SplitPane sp = new SplitPane();
 
        
        //Add all elements to split pane
        sp.getItems().addAll(vBox, allChartsVBox);
        sp.setDividerPositions(0.35f, 0.65f);
        //Label label = new Label("Your are now in the second form");
        //root2.getChildren().addAll(vBox, linechart);
        
        //Create the scene
        Scene scene = new Scene(sp, 1200,650);
        //Create the stage
        Stage stage = new Stage();
        stage.setScene(scene); // set the scene
        stage.getScene().getStylesheets().add(getClass().getResource("table.css").toExternalForm());
        stage.setResizable(true);
        //Add image to taskbar icon
        stage.getIcons().add(new Image(this.getClass().getResourceAsStream("weatherIcon.png")));
        stage.setTitle("Weahter Viewer");
        //stage.setFullScreen(true);
        stage.show();
        
        
        /*************************************
         * Create an instance of Charts class 
         * and ReadCSV class to call the
         *  methods from these classes
         * **********************************/
        Charts charts  = new Charts();
        ReadCSV callReadCSVMethod = new ReadCSV();
        
        //call readCSV method inside the choiceBox
        choiceBox.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> callReadCSVMethod.readCSV(newValue, tableView, dataList));
        
        //call methods from charts class inside the choicebox
        choiceBox.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> charts.printChart(series, columnF3, newValue, tableView));
        choiceBox.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> charts.printChart(series2, columnF4, newValue, tableView));
        choiceBox.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> charts.printChartMaxTemp(seriesMaxTemp, columnF3, newValue, tableView));
        choiceBox.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> charts.printChartMinTemp(seriesMinTemp, columnF4, newValue, tableView));
        choiceBox.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> charts.printPieChart(pieChartData, columnF5, newValue, tableView, pieChart));
        choiceBox.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> charts.printBarChart(seriesRain, columnF6, newValue, tableView));
        
        /**************************************
         * Call method readCSV  and all methods 
         * from Charts class to display the
         * table when the program is opening
         *************************************/
        callReadCSVMethod.readCSV("Aberporth", tableView, dataList);
        charts.printChart(series, columnF3, "Aberporth", tableView);
        charts.printChart(series2, columnF4, "Aberporth", tableView);
        charts.printChartMaxTemp(seriesMaxTemp, columnF3, "Aberporth", tableView);
        charts.printChartMinTemp(seriesMinTemp, columnF4, "Aberporth", tableView);
        charts.printPieChart(pieChartData, columnF5, "Aberporth", tableView, pieChart);
        charts.printBarChart(seriesRain, columnF6, "Aberporth", tableView);
        
       }
    

 
    public static void main(String[] args) {
        launch(args);
    }

}

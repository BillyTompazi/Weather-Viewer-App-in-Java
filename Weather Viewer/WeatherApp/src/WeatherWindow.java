import java.io.File;

import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class WeatherWindow {
	
		/***************************
		 * Reads HTML file and 
		 * and shows the weather map
		 * using web API
		 * @return myWebView
		 * *************************/
		public  WebView startMapWindow() {
			WebView myWebView = new WebView();
			WebEngine engine = myWebView.getEngine();
			
			//Read HTML file
			File f = new File("C:\\Users\\billy\\Desktop\\Java Assignment\\WeatherApp\\weatherApi\\googleWeatherMap.html");
			engine.load(f.toURI().toString());	
			return myWebView;
			}
}

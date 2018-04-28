import javafx.beans.property.SimpleStringProperty;

public class Record {
	 
    private SimpleStringProperty year, month, tmax, tmin, af, rain;
    
    //Constructor
    Record(String year, String month, String tmax, String tmin,
            String af, String rain) {
        this.year = new SimpleStringProperty(year);
        this.month = new SimpleStringProperty(month);
        this.tmax = new SimpleStringProperty(tmax);
        this.tmin = new SimpleStringProperty(tmin);
        this.af = new SimpleStringProperty(af);
        this.rain = new SimpleStringProperty(rain);
    }

    public String getYear() {
        return year.get();
    }

    public String getMonth() {
        return month.get();
    }

    public String getTmax() {
        return tmax.get();
    }

    public String getTmin() {
        return tmin.get();
    }

    public String getAf() {
        return af.get();
    }

    public String getRain() {
        return rain.get();
    }

}

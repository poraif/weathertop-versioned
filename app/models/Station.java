package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;



@Entity
public class Station extends Model
{
    public String name;

    public double lat;

    public double lng;


    @OneToMany(cascade = CascadeType.ALL)
    public List<Reading> readings = new ArrayList<Reading>();

    public Station (String name, double lat, double lng)
    {
        this.name = name;
        this.lat = lat;
        this.lng = lng;

    }
/*
   public List<Reading> getLatestReadings() {
         List<Reading> latestReading = null;
	//	latestReading = readings.get(readings.size()-1);
     if(readings.size() > 0) {
       latestReading = readings.subList(readings.size() - 1, readings.size());
     }
        return latestReading;
   }
*/
  public List<Reading> latestReadings() {
    List<Reading> latestReadings = null;
    if (readings.size() > 0) {
      latestReadings = readings.subList(readings.size() - 1, readings.size());
    }
    return latestReadings;
  }
}


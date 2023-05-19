package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import utils.Conversions;

import play.db.jpa.Model;



@Entity
public class Station extends Model
{
    public String name;

    public double lat;

    public double lng;

    public int minPressure;

    public int maxPressure;

    public double minTemperature;

    public double maxTemperature;

    public double minWindSpeed;

    public double maxWindSpeed;



    @OneToMany(cascade = CascadeType.ALL)
    public List<Reading> readings = new ArrayList<Reading>();

    public Station (String name, double lat, double lng)
    {
        this.name = name;
        this.lat = lat;
        this.lng = lng;
    }

  public List<Reading> latestReadings() {
    List<Reading> latestReadings = null;
    if (readings.size() > 0) {
      latestReadings = readings.subList(readings.size() - 1, readings.size());
    }
    return latestReadings;
  }
}


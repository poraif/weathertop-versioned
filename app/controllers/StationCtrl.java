package controllers;

import java.util.List;

import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;


public class StationCtrl extends Controller
{
    public static void index(Long id)
    {
        Station station = Station.findById(id);
        Logger.info ("Station id = " + id);
        render("station.html", station);
    }

    public static void deleteReading (Long id, Long readingid)
    {
        Station station = Station.findById(id);
        Reading reading = Reading.findById(readingid);
        Logger.info ("Removing reading " + reading.id);
        station.readings.remove(reading);
        station.save();
        reading.delete();
        render("station.html", station);
    }

    public static void deleteStation (Long id)
    {
        Station station = Station.findById(id);
        Logger.info ("Removing station: " + station.name);
        station.delete();
        redirect("/dashboard");
    }

    public static void addReading(Long id, int code, double temp, double windSpeed, int windDirection, int pressure)
    {
        Reading reading = new Reading(code, temp, windSpeed, windDirection, pressure);
        Station station = Station.findById(id);
        station.readings.add(reading);
        station.save();
        redirect ("/stations/" + id);
    }


}

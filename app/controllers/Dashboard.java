package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;
import models.Member;
import utils.stationAnalytics;

public class Dashboard extends Controller {
  public static void index() {
    Logger.info("Rendering Dashboard");
    Member member = Accounts.getLoggedInMember();
    List<Station> stations = member.stations;
    render("dashboard.html", member, stations);
  }


  public static void addStation (String name, double lat, double lng) {
    Member member = Accounts.getLoggedInMember();
    Station station = new Station(name, lat, lng);
    member.stations.add(station);
    member.save();
    Logger.info("Adding new station: " + name);
    redirect("/dashboard");
  }

  public static void deleteStation (Long id, long memberId)
  {
    Member member = Member.findById(memberId);
    Station station = Station.findById(id);
    member.stations.remove(station);
    member.save();
    station.delete();
    Logger.info ("Removing station: " + station.name);
    redirect("/dashboard");
  }

}

//#{listReadings station:station /}
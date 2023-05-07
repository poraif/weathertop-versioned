package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;
import models.Member;

public class Dashboard extends Controller {
  public static void index() {
    Logger.info("Rendering Dashboard");
    Member member = Accounts.getLoggedInMember();
    List<Station> stations = Station.findAll();
    render("dashboard.html", member, stations);
  }


  public static void addStation (String name, double lat, double lng) {
    Member member = Accounts.getLoggedInMember();
    Station station = new Station(name, lat, lng);
    member.stations.add(station);
    Logger.info("Adding new station: " + name);
    station.save();
    redirect("/dashboard");
  }

}

//#{listReadings station:station /}
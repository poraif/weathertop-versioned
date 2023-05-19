package models;

import javax.persistence.Entity;
import play.db.jpa.Model;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import utils.Conversions;


import java.lang.Math;

@Entity
public class Reading extends Model
{
    public int code;
    public double temperature;
    public double windSpeed;

    public int windDirection;

    public int pressure;

    public String dateTime;

    public double value;



    public Reading (int code, double temperature, double windSpeed,int windDirection, int pressure)
    {
        this.code = code;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.pressure = pressure;
        this.dateTime = getCurrentDateTime();
    }



    public String getCurrentDateTime() {
        return LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd-MM-YYYY  HH:mm:ss:SSS"));
    }

    public double getFahrenheitTemp() {
        return Conversions.celsiusToFahrenheit(temperature);
    }

    public int getBeaufort() {
        return Conversions.returnBeaufort(windSpeed);
    }

    public String getCompassDirection() {
        return Conversions.compassDirection(windDirection);
    }

    public String getWeatherCondition() {
        return Conversions.convertWeatherCode(code);
    }

    public double getWindChill() {
        return Conversions.calcWindChill (windSpeed, temperature);
    }







    public static double calcWindChill (double windSpeed, double temperature) {
        double i = Math.pow(windSpeed, 0.16);
        return (Math.round((13.12 + (0.6215 * temperature) - (11.37 * i) + ((0.3965 * temperature) * i))*100)/100.0);
    }





}


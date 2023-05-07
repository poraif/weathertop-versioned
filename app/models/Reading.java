package models;

import javax.persistence.Entity;
import play.db.jpa.Model;
//import utilities.Calculations;

import java.lang.Math;

@Entity
public class Reading extends Model
{
    public int code;
    public double temperature;
    public double windSpeed;

    public int windDirection;

    public int pressure;



    public Reading (int code, double temperature, double windSpeed,int windDirection, int pressure)
    {
        this.code = code;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.pressure = pressure;
    }

    public static double  celsiusToFahrenheit(double temperature)
    {
        return((temperature*1.8) + 32);
    }

    public static int returnBeaufort(double windSpeed){
        int beaufort = 0;

        if (windSpeed == 1.0) {
            beaufort = 0;
        }
        else if ((windSpeed > 1.0) && (windSpeed <= 5.0)) {
            beaufort = 1;
        }
        else if ((windSpeed > 5.0) && (windSpeed <= 11.0)) {
            beaufort = 2;
        }
        else if ((windSpeed > 11.0) && (windSpeed <= 19.0)) {
            beaufort = 3;
        }
        else if ((windSpeed > 19.0) && (windSpeed <= 28.0)) {
            beaufort = 4;
        }
        else if ((windSpeed > 28.0) && (windSpeed <= 38.0)) {
            beaufort = 5;
        }
        else if ((windSpeed > 39.0) && (windSpeed <= 49.0)) {
            beaufort = 6;
        }
        else if ((windSpeed > 49.0) && (windSpeed <= 61.0)) {
            beaufort = 7;
        }
        else if ((windSpeed > 61.0) && (windSpeed <= 74.0)) {
            beaufort = 8;
        }
        else if ((windSpeed > 74.0) && (windSpeed <= 88.0)) {
            beaufort = 9;
        }
        else if ((windSpeed > 88.0) && (windSpeed <= 102.0)) {
            beaufort = 10;
        }
        else if ((windSpeed > 102.0) && (windSpeed <= 117.0)) {
            beaufort = 11;
        }
        return beaufort;
    }

    public static String getCompassDirection(int windDirection){
        String compassDirection = "North";

        if (((windDirection > 348.75) && (windDirection <= 360)) || ((windDirection > 0) && (windDirection <= 11.25))) {
            compassDirection = "North";
        }
        else if ((windDirection > 11.25) && (windDirection <= 33.75)) {
            compassDirection = "North North East";
        }
        else if ((windDirection > 33.75) && (windDirection <= 56.25)) {
            compassDirection = "North East";
        }
        else if ((windDirection > 56.25) && (windDirection <= 78.75)) {
            compassDirection = "East North East";
        }
        else if ((windDirection > 78.75) && (windDirection <= 101.25)) {
            compassDirection = "East";
        }
        else if ((windDirection > 101.25) && (windDirection <= 123.75)) {
            compassDirection = "East South East";
        }
        else if ((windDirection > 123.75) && (windDirection <= 146.25)) {
            compassDirection = "South East";
        }
        else if ((windDirection > 146.25) && (windDirection <= 168.75)) {
            compassDirection = "South South East";
        }
        else if ((windDirection > 168.75) && (windDirection <= 191.25)) {
            compassDirection = "South";
        }
        else if ((windDirection > 191.25) && (windDirection <= 213.75)) {
            compassDirection = "South South West";
        }
        else if ((windDirection > 213.75) && (windDirection <= 236.25)) {
            compassDirection = "South West";
        }
        else if ((windDirection > 236.25) && (windDirection <= 258.75)) {
            compassDirection = "West South West";
        }
        else if ((windDirection > 258.75) && (windDirection <= 281.25)) {
            compassDirection = "West";
        }
        else if ((windDirection > 281.25) && (windDirection <= 303.75)) {
            compassDirection = "West North West";
        }
        else if ((windDirection > 303.75) && (windDirection <= 326.25)) {
            compassDirection = "North West";
        }
        else if ((windDirection > 326.25) && (windDirection <= 348.75)) {
            compassDirection = "North North West";
        }
        return compassDirection;
    }

    public static String convertWeatherCode(int code){

        String weatherOutput = "clear";

        switch (code){
            case 100:    weatherOutput = "Clear";
                break;
            case 200:    weatherOutput = "Partial clouds";
                break;
            case 300:    weatherOutput = "Cloudy";
                break;
            case 400:    weatherOutput = "Light showers";
                break;
            case 500:    weatherOutput = "Heavy showers";
                break;
            case 600:    weatherOutput = "Rain";
                break;
            case 700:    weatherOutput = "Snow";
                break;
            case 800:    weatherOutput = "Thunder";
                break;
            default:    weatherOutput = "clear";
                break;
        }
        return weatherOutput;
    }

    public static double calcWindChill (double windSpeed, double temperature) {
        double i = Math.pow(windSpeed, 0.16);
        return (13.12 + (0.6215 * temperature) - (11.37 * i) + ((0.3965 * temperature) * i));
    }
}


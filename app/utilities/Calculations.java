/**
package utilities;
import java.lang.Math;
public class Calculations {



        }Compass Direction
        Degree Range
        N 348.75-11.25
        NNE 11.25-33.75
        NE 33.75-56.25
        ENE 56.25-78.75
        E 78.75 -101.25
        ESE 101.25 -123.75
        SE 123.75-146.25
        SSE 146.25-168.75
        S 168.75 -191.25
        SSW 191.25-213.75
        SW 213.75-236.25
        WSW 236.25-258.75
        W 258.75-281.25
        WNW 281.25-303.75
        NW 303.75-326.25
        NNW 326.25-348.75




        public static String convertWeatherCode(int weatherCode){
            int weatherCode = reading.code;
            String weatherOutput = "clear";

                switch (weatherCode){
                    case 100:    weatherOutput = "Clear";
                        break;
                    case 200:    weatherOutput = "Partial clouds;
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
                    default:    System.out.println("Invalid option entered: " + option;
                        break;
                    return weatherOutput;
                    }
 }

 public static int returnBeaufort(int windSpeed){
         int windSpeed = 0;
        int beaufort = 0;
         String weatherOutput = "clear";

             if (windSpeed == 1) {
             beaufort = 0;
             }
             else if ((windSpeed > 1) && (windSpeed <= 5)) {
             beaufort = 1;
             }
             else if ((windSpeed > 5) && (windSpeed <= 11)) {
             beaufort = 2;
             }
             else if ((windSpeed > 11) && (windSpeed <= 19)) {
             beaufort = 3;
             }
             else if ((windSpeed > 19) && (windSpeed <= 28)) {
             beaufort = 4;
             }
             else if ((windSpeed > 28) && (windSpeed <= 38)) {
             beaufort = 5;
             }
             else if ((windSpeed > 39) && (windSpeed <= 49)) {
             beaufort = 6;
             }
             else if ((windSpeed > 49) && (windSpeed <= 61)) {
             beaufort = 7;
             }
             else if ((windSpeed > 61) && (windSpeed <= 74)) {
             beaufort = 8;
             }
             else if ((windSpeed > 74) && (windSpeed <= 88)) {
             beaufort = 9;
             }
             else if ((windSpeed > 88) && (windSpeed <= 102)) {
             beaufort = 10;
             }
             else if ((windSpeed > 102) && (windSpeed <= 117)) {
             beaufort = 11;
             }
 return beaufort;
 }






                public static int calcWindChill (windSpeed, temp) {
                    double i = Math.pow(windSpeed, 0.16);
                    return (13.12 + (0.6215 * temp)) - ((11.37 * i) + ((0.3965 * temp) * i));
                }

                public static double  celsiusToFahrenheit(temp)
                        {
                return((temp*(9/5)) + 32);
            }
}
**/
package utils;

import models.Reading;
import models.Station;
import java.util.List;

public class stationAnalytics {
    public static int getMinPressure(List<Reading> readings) {
        Reading minPressure = null;
        if (readings.size() > 0) {
            minPressure = readings.get(0);
            for (Reading reading : readings) {
                if (reading.pressure < minPressure.pressure) {
                    minPressure = reading;
                }
            }
            return minPressure.pressure;
        }
    else {
                return 0;
            }

    }

    public static int getMaxPressure(List<Reading> readings) {
        Reading maxPressure = null;
        if (readings.size() > 0) {
            maxPressure = readings.get(0);
            for (Reading reading : readings) {
                if (reading.pressure > maxPressure.pressure) {
                    maxPressure = reading;
                }
            }
            return maxPressure.pressure;
        }
        else {
            return 0;
        }

    }

    public static double getMinTemperature(List<Reading> readings) {
        Reading minTemperature = null;
        if (readings.size() > 0) {
            minTemperature = readings.get(0);
            for (Reading reading : readings) {
                if (reading.temperature < minTemperature.temperature) {
                    minTemperature = reading;
                }
            }
            return minTemperature.temperature;
        }
        else {
            return 0.0;
        }

    }

    public static double getMaxTemperature(List<Reading> readings) {
        Reading maxTemperature = null;
        if (readings.size() > 0) {
            maxTemperature = readings.get(0);
            for (Reading reading : readings) {
                if (reading.temperature > maxTemperature.temperature) {
                    maxTemperature = reading;
                }
            }
            return maxTemperature.temperature;
        }
        else {
            return 0.0;
        }

    }

    public static double getMinWindSpeed(List<Reading> readings) {
        Reading minWindSpeed = null;
        if (readings.size() > 0) {
            minWindSpeed = readings.get(0);
            for (Reading reading : readings) {
                if (reading.windSpeed < minWindSpeed.windSpeed) {
                    minWindSpeed = reading;
                }
            }
            return minWindSpeed.windSpeed;
        }
        else {
            return 0.0;
        }

    }

    public static double getMaxWindSpeed(List<Reading> readings) {
        Reading maxWindSpeed = null;
        if (readings.size() > 0) {
            maxWindSpeed = readings.get(0);
            for (Reading reading : readings) {
                if (reading.windSpeed > maxWindSpeed.windSpeed) {
                    maxWindSpeed = reading;
                }
            }
            return maxWindSpeed.windSpeed;
        }
        else {
            return 0.0;
        }

    }

}

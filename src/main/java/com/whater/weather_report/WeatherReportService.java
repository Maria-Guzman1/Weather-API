package com.whater.weather_report;

public interface WeatherReportService {
    String wait(String city);

    WeatherReport getWeatherReport(double latitude, double longitude);

    default char[] getWeatherReport(String london) {
        return null;
    }
}

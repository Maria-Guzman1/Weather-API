package com.whater.weather_report;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class WeatherReportServiceTes {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private WeatherReportService weatherReportService;

    @Test
    void testGetWeatherReport() {
        String expectedResponse = "weather report for city";
        String url = "http://example.com/weather?city=London"; // Ajusta la URL según sea necesario

        when(restTemplate.getForObject(anyString(), eq(String.class)))
                .thenReturn(expectedResponse);

        String actualResponse = Arrays.toString(weatherReportService.getWeatherReport("London"));

        assertEquals(expectedResponse, actualResponse);
    }
}

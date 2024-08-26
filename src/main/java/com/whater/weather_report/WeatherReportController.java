package com.whater.weather_report;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

class WeatherReportServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private WeatherReportService weatherReportService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa los mocks
    }

    @Test
    void testGetWeatherReport() {
        // El resultado esperado de la llamada a la API
        String expectedResponse = "weather report for London";

        // Construye la URL que se espera que se genere en el método
        String expectedUrl = "http://api.weather.com/v3/wx/conditions/current?city=London&apiKey=yourApiKey";

        // Simula la respuesta del RestTemplate para la URL construida
        when(restTemplate.getForObject(expectedUrl, String.class))
                .thenReturn(expectedResponse);

        // Llama al método que deseas probar
        String actualResponse = Arrays.toString(weatherReportService.getWeatherReport("London"));

        // Verifica que el resultado sea el esperado
        assertEquals(expectedResponse, actualResponse);
    }
}

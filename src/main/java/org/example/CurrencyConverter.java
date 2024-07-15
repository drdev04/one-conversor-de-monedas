package org.example;
import org.example.model.ExchangeRateResponse;
import com.google.gson.JsonObject;
import java.io.IOException;
import org.apache.hc.core5.http.ParseException;

public class CurrencyConverter {
    private final ExchangeRateApiClient apiClient = new ExchangeRateApiClient();
    private ExchangeRateResponse exchangeRateResponse;

    public CurrencyConverter() {
        this.exchangeRateResponse = apiClient.getExchangeRates();
    }

    public double convert(double amount, String targetCurrency) {
        if (exchangeRateResponse == null) {
            throw new IllegalStateException("No se pudo obtener las tasas de cambio.");
        }
        JsonObject rates = exchangeRateResponse.getConversionRates();
        double rate = rates.get(targetCurrency).getAsDouble();
        return amount * rate;
    }

  /*private final ExchangeRateApiClient apiClient = new ExchangeRateApiClient();
    private ExchangeRateResponse exchangeRateResponse;

    public CurrencyConverter() {
        try {
            this.exchangeRateResponse = apiClient.getExchangeRates();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            // Manejo de errores, por ejemplo, establecer exchangeRateResponse a un valor por defecto
        }
    }

    public double convert(double amount, String targetCurrency) {
        if (exchangeRateResponse == null) {
            throw new IllegalStateException("Exchange rates not available");
        }

        Double rate = exchangeRateResponse.getConversionRates().get(targetCurrency);
        if (rate == null) {
            throw new IllegalArgumentException("Invalid target currency");
        }
        return amount * rate;
    }*/
}

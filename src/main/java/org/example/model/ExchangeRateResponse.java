package org.example.model;
import com.google.gson.JsonObject;

public class ExchangeRateResponse {
    private String result;
    private JsonObject conversion_rates;

    public String getResult() {
        return result;
    }

    public JsonObject getConversionRates() {
        return conversion_rates;
    }
}

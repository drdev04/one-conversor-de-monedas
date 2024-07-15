package org.example;
import org.example.model.ExchangeRateResponse;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import java.io.IOException;

public class ExchangeRateApiClient {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/e10ef62081a255644258045b/latest/USD";

    public ExchangeRateResponse getExchangeRates() throws IOException, ParseException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(API_URL);
            try (CloseableHttpResponse response = httpClient.execute(request)) {
                String jsonResponse = EntityUtils.toString(response.getEntity());
                Gson gson = new Gson();
                return gson.fromJson(jsonResponse, ExchangeRateResponse.class);
            }
        }
    }
}

package android.telacad.ro.jmc6e1.model;

import java.util.Map;

/**
 * Created by student on 10/14/2017.
 */

public class ExchangeResponse {
    private String base;
    private String date;
    private Map<String, Double> rates;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }
}

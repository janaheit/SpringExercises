package be.abis.exercise.apimodel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PriceUpdateModel {
    private String id;
    @JsonProperty(value = "price-per-day")
    private double pricePerDay;

    public PriceUpdateModel() {
    }

    public PriceUpdateModel(String id, double pricePerDay) {
        this();
        this.id = id;
        this.pricePerDay = pricePerDay;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }
}

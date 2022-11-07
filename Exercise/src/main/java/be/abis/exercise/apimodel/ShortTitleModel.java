package be.abis.exercise.apimodel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShortTitleModel {
    @JsonProperty(value = "short-title")
    private String shortTitle;

    public ShortTitleModel() {
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }
}

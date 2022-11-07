package be.abis.exercise.error;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

public class ApiError {
    private String title;
    private int status;
    private String description;
    private String type = "about:blank";
    private String instance ="";
    @JsonProperty("invalid-param")
    private List<ValidationError> invalidParam = new ArrayList<>();

    public ApiError() {
    }

    public ApiError(String title, int status, String description) {
        this();
        this.title = title;
        this.status = status;
        this.description = description;
    }

    public ApiError(String title, int status, String description, List<ValidationError> invalidParam) {
        this(title, status, description);
        this.invalidParam = invalidParam;
    }

    public List<ValidationError> getInvalidParam() {
        return invalidParam;
    }

    public void setInvalidParam(List<ValidationError> invalidParam) {
        this.invalidParam = invalidParam;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

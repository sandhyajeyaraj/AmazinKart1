import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
@JsonIgnoreProperties
public class ExchangeApiModel {

    @JsonProperty("rates")
    private HashMap<String, String> rates;

    @JsonProperty("base")
    private String base;

    @JsonProperty("date")
    private String date;

}




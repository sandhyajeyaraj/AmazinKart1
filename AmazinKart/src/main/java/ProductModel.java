import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;


@Getter
@Setter
@ToString
@JsonIgnoreProperties
public class ProductModel{

    @JsonProperty("category")
    private String category;

    @JsonProperty("inventory")
    private int inventory;

    @JsonProperty("rating")
    private int rating;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("price")
    private String price;

    @JsonProperty("origin")
    private String origin;

    @JsonProperty("product")
    private String product;

    @JsonProperty("arrival")
    private String arrival;

}

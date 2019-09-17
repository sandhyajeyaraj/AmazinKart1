package Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties
public class discount {

    @JsonProperty("amount")
    private String amount;

    @JsonProperty("discountTag")
    private String discountTag;

    @JsonProperty("ProductModel")
    private ProductModel productModel;
}

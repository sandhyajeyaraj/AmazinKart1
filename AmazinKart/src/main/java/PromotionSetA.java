import java.io.IOException;
import java.util.List;

public class PromotionSetA {

    public static void main(String args[]) throws IOException {

        RetreiveDetails retreiveDetails = new RetreiveDetails();
        ProcessPromotionSetA promoA = new ProcessPromotionSetA();

        List<ProductModel> parsedData= retreiveDetails.retrieveProductDetails();

        List<discount> promoAResult = promoA.ProcessPromotionSetA(parsedData);

        System.out.println("Promtion Set A response: " +promoAResult.toString());

    }
}
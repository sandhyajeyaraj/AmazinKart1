package Main;

import Service.ProcessPromotionSetB;

import java.io.IOException;
import java.util.List;
import Utility.RetreiveDetails;
import Model.discount;
import Model.ProductModel;

public class PromotionSetB {

    public static void main(String args[]) throws IOException {

        RetreiveDetails retreiveDetails = new RetreiveDetails();
        ProcessPromotionSetB promoB = new ProcessPromotionSetB();

        List<ProductModel> parsedData= retreiveDetails.retrieveProductDetails();

        List<discount> promoBResult = promoB.ProcessPromotionSetB(parsedData);

        System.out.println("Promtion Set B response: " +promoBResult.toString());

    }
}
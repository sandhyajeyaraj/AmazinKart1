import java.util.ArrayList;
import java.util.List;

public class ProcessPromotionSetB {

    public List<discount> ProcessPromotionSetB(List<ProductModel> productModel)
    {

        discount finalResponseModel = new discount();

        List<discount> finalResponseList = new ArrayList<discount>();
        String DiscountType ="";
        for(ProductModel input : productModel)
        {
            double Price =Double.parseDouble(input.getPrice());
            double discount= 0;
            double Maxdiscount =0;
            if(input.getInventory()>20)
            {
                Maxdiscount = (Maxdiscount<=discount)?Price *0.12: Maxdiscount;
                DiscountType = "get 12% off";
            }
            if (input.getArrival()!=null && (input.getArrival().equals("NEW") ||input.getArrival().equals("new")))
            {
                Maxdiscount = (Maxdiscount<=discount)?Price * 0.07: Maxdiscount;
                DiscountType = "get 7% off";
            }
            else
            {
                if (Price >= 1000)
                {
                    Maxdiscount = (Maxdiscount<=discount)?Price*0.02: Maxdiscount;
                    DiscountType = "get 2% off";
                }
            }
            finalResponseModel.setAmount(String.valueOf(Maxdiscount));
            finalResponseModel.setDiscountTag(DiscountType);
            finalResponseModel.setProductModel(input);
            finalResponseList.add(finalResponseModel);
        }
        return finalResponseList;
    }
}

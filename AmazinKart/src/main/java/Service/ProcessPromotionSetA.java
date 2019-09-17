package Service;

import java.util.ArrayList;
import java.util.List;
import Model.discount;
import Model.ProductModel;

public class ProcessPromotionSetA {

    public List<discount> ProcessPromotionSetA(List<ProductModel> productModel)
    {

        discount finalResponseModel = new discount();

        List<discount> finalResponseList = new ArrayList<discount>();
        String DiscountType ="";
        for(ProductModel input : productModel)
        {
            double Price =Double.parseDouble(input.getPrice());
            double discount= 0;
            double Maxdiscount =0;
            if(input.getOrigin().equals("Africa"))
            {
                Maxdiscount = (Maxdiscount<=discount)?Price *0.07: Maxdiscount;
                DiscountType = "get 7% off";
            }
             if (input.getRating() == 2)
            {
                Maxdiscount = (Maxdiscount<=discount)?Price * 0.04: Maxdiscount;
                DiscountType = "get 4% off";
            }
             if (input.getRating() < 2)
            {
                Maxdiscount = (Maxdiscount<=discount)?Price * 0.08: Maxdiscount;
                DiscountType = "get 8% off";
            }
             if ((input.getCategory().equals("electronics") || input.getCategory().equals("furnishing")) && Integer.parseInt(input.getPrice()) >= 500 )
            {
                Maxdiscount = (Maxdiscount<=discount)?Price- 100: Maxdiscount;
                DiscountType = "get Rs 100 off";
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

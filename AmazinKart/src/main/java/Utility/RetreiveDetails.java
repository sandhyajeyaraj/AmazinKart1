package Utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileWriter;
import Model.ProductModel;
import Model.ExchangeApiModel;


public class RetreiveDetails {

    public List<ProductModel> retrieveProductDetails() throws IOException {

        String productDetails = processProductDetails("https://api.jsonbin.io/b/5d31a1c4536bb970455172ca/latest");

        String exchangeRatesApiDetails = processProductDetails(" https://api.exchangeratesapi.io/latest");

        List<ProductModel> parsedData = parseInputData(productDetails, exchangeRatesApiDetails);

        return parsedData;
    }

    public String processProductDetails(String apiUrl) throws IOException {
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");
        connection.connect();

        int code = connection.getResponseCode();
        InputStream inputStream;
        if (code == 200) {
            inputStream = connection.getInputStream();
        } else {
            inputStream = connection.getErrorStream();
        }

        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        inputStream));

        StringBuilder response = new StringBuilder();
        String currentLine;

        while ((currentLine = in.readLine()) != null)
            response.append(currentLine);

        in.close();

        return response.toString();
    }

    public List<ProductModel> parseInputData(String productDetails, String exchangeRatesApiDetails) throws IOException {
        ProductModel[] model;
        ObjectMapper objectMapper = new ObjectMapper();
        model = objectMapper.readValue(productDetails, ProductModel[].class);

        ExchangeApiModel exhModel;
        exhModel = objectMapper.readValue(exchangeRatesApiDetails, ExchangeApiModel.class);

        List<ProductModel> output = new ArrayList<ProductModel>();
        for (ProductModel m : model) {
            String currency = m.getCurrency();
            String price;
            if (!m.getCurrency().equals("INR")) {
                if (exhModel.getRates().containsKey(currency)) {
                    price = exhModel.getRates().get(currency);
                    m.setCurrency("INR");
                    m.setPrice(price);
                }
            }
            output.add(m);
        }
        WriteToFile(output);
        return output;
    }

    public void WriteToFile(List<ProductModel> output) throws IOException
    {
        try {
        // if  the code is executed in mac "the file path need to be specifed in this pattern"
            FileWriter file = new FileWriter("\\Output\\Output.json") ;
            file.write(output.toString());

          file.close();

        }catch (IOException e) {
            // if incase the code is executed in windows "the file path need to be specifed in this pattern"
            FileWriter filewindow = new FileWriter("/Output/Output.json") ;
            filewindow.write(output.toString());
            filewindow.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}


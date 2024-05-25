import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class BusquedaConExchange {

    public double buscarMonedas(String moneda) throws IOException {
        String url_str ="https://v6.exchangerate-api.com/v6/3a4a25fc282e1ed5a79c0e69/latest/USD";

        URL url = new URL(url_str);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

// Convert to JSON
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();

        JsonObject conversionRates = jsonobj.getAsJsonObject("conversion_rates");

        double rate;

// Accessing object
//        String req_result = String.valueOf(jsonobj.get("conversion_rates").getAsJsonObject().get(moneda));
//        String req_Conversion = String.valueOf(jsonobj.get("conversion_rates").getAsJsonObject());
//        System.out.println("La moneda elegida fue "+moneda+ req_result);
        switch (moneda.toUpperCase()){
            case "ARS":
                rate = conversionRates.get("ARS").getAsDouble();
                break;

            case "BRL":
                rate = conversionRates.get("BRL").getAsDouble();
                break;

            case "COP":
                rate = conversionRates.get("COP").getAsDouble();
                break;
            case "USD":
                rate = conversionRates.get("USD").getAsDouble();
                break;

            default:
                System.out.println(" La moneda " + moneda +
                        " no se encontro. ");
                throw new IllegalArgumentException("La moneda " + moneda + " no se encontró.");
        }

//        if (conversionRates.has(moneda)) {
//            String req_result = conversionRates.get(moneda).getAsString();
//          //  int ireq_result = Integer.parseInt(req_result);
//            System.out.println("La moneda elegida fue " + moneda + ": " + req_result);
//            return "La tasa de cambio de USD a " + moneda + " es: " + req_result;
//        } else {
//            System.out.println("La moneda " + moneda + " no se encontró.");
//            return "La moneda " + moneda + " no se encontró.";
//        }
        System.out.println();
        return rate;
    }

    public double convertirUsdMoneda(String moneda, double cantidad) throws IOException{
        double tasaDeCambio = buscarMonedas(moneda);
        return cantidad * tasaDeCambio;
    }

    public double convertirMonedaUsd(String moneda, double cantidad) throws IOException{
        double tasaDeCambio = buscarMonedas(moneda);
        return cantidad / tasaDeCambio;
    }
}

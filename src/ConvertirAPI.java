import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConvertirAPI {
    public Monedas convertir ( String base, String cambiar){

        var API = "d18cc01bf9d8cb79ca14134b";


        URI dirreccion = URI.create("https://v6.exchangerate-api.com/v6/"+API+"/pair/"+base+"/"+cambiar+"/");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(dirreccion)
                .build();

        try{
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Monedas.class);

        } catch (Exception e) {
            throw new RuntimeException("No se encontro la moneda");
        }
    }
}

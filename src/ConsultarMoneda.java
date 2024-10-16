import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class ConsultarMoneda {
    public Moneda convertirMoneda (String origen, String destino, double valor){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/325cc20278615bec285e0d44/pair/" +
                origen + "/" +
                destino + "/" +
                valor);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);

        } catch (Exception e) {
            throw new RuntimeException("No encontré esa moneda");
        }
    }


}

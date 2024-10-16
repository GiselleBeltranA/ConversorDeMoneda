import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;


public class GeneradorDeArchivo {

    public void guardarJson(Moneda consultarMoneda) throws IOException {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escritura = new FileWriter("busqueda.json");
        escritura.write(gson.toJson(consultarMoneda));
        escritura.close();

    }
}
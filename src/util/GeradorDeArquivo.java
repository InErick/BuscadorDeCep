package util;

import dto.EnderecoDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeradorDeArquivo {

    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();
    public void salvarJson(EnderecoDTO enderecoDTO) throws IOException {
        FileWriter fileWriter = new FileWriter("endereco.json");
        fileWriter.write(gson.toJson(enderecoDTO));
        fileWriter.close();
    }
}

package Client;

import DTO.EnderecoDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ViaCepClient {
    public final Gson gson;
    public final HttpClient httpClient;

    public ViaCepClient() {
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        this.httpClient = HttpClient.newHttpClient();
    }

    public EnderecoDTO buscar(String cep) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(java.net.URI.create("https://viacep.com.br/ws/" + cep + "/json/"))
                .build();

        HttpResponse<String> response = httpClient.send(
                request,
                HttpResponse.BodyHandlers.ofString());

        EnderecoDTO endereco = gson.fromJson(response.body(), EnderecoDTO.class);
        return endereco;
    }

}

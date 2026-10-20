package client;

import dto.EnderecoDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ViaCepClient {
    private final Gson gson;
    private final HttpClient httpClient;

    public ViaCepClient() {
        this.gson = new GsonBuilder()
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

        if(response.statusCode() != 200) {
            throw new IOException("Erro ao buscar o CEP: " + response.statusCode());
        }
        if(response.body().contains("erro")) {
            throw new IOException("CEP não encontrado.");
        }

        EnderecoDTO endereco = gson.fromJson(response.body(), EnderecoDTO.class);
        return endereco;
    }

}

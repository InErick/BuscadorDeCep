package service;

import client.ViaCepClient;
import util.GeradorDeArquivo;

public class CepService {
    private ViaCepClient viaCepClient = new ViaCepClient();
    private GeradorDeArquivo geradorDeArquivo = new GeradorDeArquivo();

    public void processarBuscaCep(String cep) {
        String cepLimpo = cep.replaceAll("[^0-9]", "");

        if (cepLimpo.length() != 8) {
            System.out.println("CEP inválido. Por favor, forneça um CEP válido.");
            return;
        }
        try {
            var endereco = viaCepClient.buscar(cepLimpo);
            geradorDeArquivo.salvarJson(endereco);
            System.out.println(endereco);
        } catch (Exception e) {
            System.out.println("Erro ao buscar o CEP: " + e.getMessage());
        }
    }
}

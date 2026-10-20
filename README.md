# Buscador de CEP 📍

Aplicação em **Java** desenvolvida para consulta de endereços a partir de um CEP via linha de comando (CLI), integrando com a API pública do **ViaCEP** e persistindo o resultado em formato JSON.

Projeto desenvolvido durante as atividades e exercícios da formação Java da **Alura** (focado em consumo de APIs, tratamento de exceções, manipulação de arquivos e biblioteca Gson).

---

## 🛠️ Tecnologias e Bibliotecas

- **Java 21** (utilizando recursos modernos como `record` e `java.net.http.HttpClient`)
- **[Gson](https://github.com/google/gson)** (Google Gson): Serialização e desserialização de JSON com formatação legível (*pretty printing*)
- **[ViaCEP API](https://viacep.com.br/)**: Webservice gratuito para consulta de CEPs brasileiros

---

## 📋 Funcionalidades

- **Entrada via terminal**: Leitura dinâmica do CEP informado pelo usuário via `Scanner`.
- **Validação e sanitização**: Limpeza de caracteres não numéricos (`replaceAll`) e validação de tamanho (8 dígitos).
- **Consumo HTTP nativo**: Requisições HTTP com `HttpClient`, `HttpRequest` e `HttpResponse`.
- **Mapeamento de dados**: Conversão automática do JSON da API para o record `EnderecoDTO`.
- **Geração de arquivo JSON**: Exportação dos dados formatados para o arquivo `endereco.json`.
- **Tratamento de exceções**: Captura e exibição amigável de erros durante a consulta ou escrita do arquivo.

---

## 📂 Estrutura do Projeto

```text
BuscadorCEP/
├── src/
│   ├── client/
│   │   └── ViaCepClient.java       # Cliente HTTP responsável pela requisição à API ViaCEP
│   ├── dto/
│   │   └── EnderecoDTO.java        # Record Java com os campos retornados pelo ViaCEP
│   ├── service/
│   │   └── CepService.java         # Regra de negócio: validação do CEP e orquestração do fluxo
│   ├── util/
│   │   └── GeradorDeArquivo.java   # Responsável por salvar os dados em endereco.json
│   └── Main.java                   # Classe principal e ponto de entrada da aplicação
├── endereco.json                   # Arquivo gerado com os dados da última consulta
└── README.md                       # Documentação do projeto
```

---

## 🚀 Como Executar

### Pré-requisitos
- **Java JDK 17** ou superior instalado.
- Biblioteca **Gson** (ex: `gson-2.14.0.jar`) adicionada ao classpath / dependências da IDE.

### Execução via IDE (IntelliJ IDEA, Eclipse ou VS Code)
1. Abra o projeto na sua IDE de preferência.
2. Certifique-se de que a biblioteca **Gson** está configurada nas dependências do projeto (*Libraries* / *Dependencies*).
3. Execute a classe [`Main.java`](src/Main.java).
4. No console, informe um CEP (com ou sem máscara, por exemplo `01001000` ou `01001-000`).
5. O resultado será exibido e gravado automaticamente no arquivo [`endereco.json`](endereco.json).

---

## 📄 Exemplo do Arquivo Gerado (`endereco.json`)

```json
{
  "cep": "27330-400",
  "logradouro": "Rua Domingos José Dantas",
  "complemento": "",
  "bairro": "Boa Sorte",
  "localidade": "Barra Mansa",
  "uf": "RJ",
  "estado": "Rio de Janeiro",
  "regiao": "Sudeste",
  "ibge": "3300407",
  "gia": "",
  "ddd": "24",
  "siafi": "5807"
}
```

---

## 🎓 Aprendizados

- Uso do cliente HTTP nativo do Java (`java.net.http`).
- Mapeamento e imutabilidade com **Java Records**.
- Manipulação e formatação de JSON com a biblioteca **Gson**.
- Escrita de arquivos locais usando `FileWriter`.
- Separação de responsabilidades em camadas (`client`, `service`, `dto`, `util`).

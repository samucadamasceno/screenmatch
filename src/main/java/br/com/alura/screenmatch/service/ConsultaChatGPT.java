package br.com.alura.screenmatch.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGPT {
    public static String obterTraducao(String texto) {
        OpenAiService service = new OpenAiService("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");

        CompletionRequest requisicao = CompletionRequest.builder()
                .model("gpt-3.5-turbo-instruct")
                .prompt("traduza para o português o texto: " + texto)
                .maxTokens(1000)
                .temperature(0.7)
                .build();

        var resposta = service.createCompletion(requisicao);
        return resposta.getChoices().get(0).getText();
    }
}
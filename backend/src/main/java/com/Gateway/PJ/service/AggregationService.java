package com.Gateway.PJ.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.Gateway.PJ.dto.TransactionDataDTO;
import com.Gateway.PJ.dto.TransactionResponseDTO;

import reactor.core.publisher.Mono;

@Service
public class AggregationService {

    private final WebClient webClient;

    public AggregationService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8080").build();
    }

   
    public List<TransactionDataDTO> aggregateTransactions() {

        
        Mono<TransactionResponseDTO> requestBankA = getTransactionsOfBankA();
        Mono<TransactionResponseDTO> requestBankB = getTransactionsOfBankB();
        
 
        
        return Mono.zip(requestBankA, requestBankB).map(
            tuple -> {
            TransactionResponseDTO responseA = tuple.getT1();
            TransactionResponseDTO responseB = tuple.getT2();

            //Extraia as listas de dados de cada resposta.
            List<TransactionDataDTO> transactionsA = responseA.getData();
            List<TransactionDataDTO> transactionsB = responseB.getData();

            // Junte as duas listas em uma só.
            List<TransactionDataDTO> combinedList = new ArrayList<>();
            combinedList.addAll(transactionsA);
            combinedList.addAll(transactionsB);

            return combinedList;
            }).block();
    }

  
    private Mono<TransactionResponseDTO> getTransactionsOfBankA() {
        return webClient.get()
                .uri("/mock/bankA/accounts/123/transactions") // URI corrigido
                .retrieve()
                .bodyToMono(TransactionResponseDTO.class);
    }

    private Mono<TransactionResponseDTO> getTransactionsOfBankB() {
        return webClient.get()
                .uri("/mock/bankB/accounts/123/transactions") // URI para o banco B
                .retrieve()
                .bodyToMono(TransactionResponseDTO.class);
    }
}
package com.Gateway.PJ.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.Gateway.PJ.dto.TransactionDataDTO;
import com.Gateway.PJ.dto.TransactionResponseDTO;
import com.Gateway.PJ.exceptions.ResourceNotFoundException;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AggregationService {

    // makes asynchronous, non-blocking HTTP requests
    private final WebClient webClient;

    public AggregationService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8080").build();
    }

    
    // The idea is take all transaction of all bancks of a user
    // In future could be take all transaction in a period like a month
    public Page<TransactionDataDTO> aggregateTransactions(String userId , Pageable pageable) {

          // --- User mock ---
    // In future this will be a call for userservice.
        List<String> idsForUser;
        if ("franco123".equals(userId)) {
            idsForUser = List.of("bankA", "bankB");
        } else if ("outroUsuario".equals(userId)) {
            idsForUser = List.of("bankA");
        } else {
            throw new ResourceNotFoundException("user not found with id:" + userId);
        }
        // For EACH bankId, call our generic method.
        List<TransactionDataDTO> allTransactions =  Flux.fromIterable(idsForUser)

        // "Joins" all Mono into one continuous stream  
        .flatMap(bankId -> getTransactionsOfBank(bankId))

        // Transforms the stream into a Flux<List<TransactionDataDTO>>
        .map(response -> response.getData())

        .flatMap(list -> Flux.fromIterable(list))

        .collectList()

        .block();

        int start = (int) pageable.getOffset();

        int end = Math.min(start + pageable.getPageSize() , allTransactions.size());

        List<TransactionDataDTO> pageContent;

        if (start > allTransactions.size()) {

        pageContent = List.of();
    } else {
      
        pageContent = allTransactions.subList(start, end);
    }

        return new PageImpl<>(pageContent, pageable, allTransactions.size());


    }

  
    private Mono<TransactionResponseDTO> getTransactionsOfBank(String bankId) {

        String uriPath = String.format("/mock/%s/accounts/123/transactions", bankId);

        return webClient.get()
                .uri(uriPath)
                .retrieve()
                .bodyToMono(TransactionResponseDTO.class);
    }

  

}
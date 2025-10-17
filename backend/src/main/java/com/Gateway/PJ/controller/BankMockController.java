package com.Gateway.PJ.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Gateway.PJ.controller.docs.BankMockControllerDocs;
import com.Gateway.PJ.dto.TransactionResponseDTO;
import com.Gateway.PJ.service.MockDataService;

@RestController()
@RequestMapping("/mock")
public class BankMockController implements BankMockControllerDocs {

    @Autowired
    MockDataService service;

    @GetMapping(
        value = "/bankA/accounts/{accountId}/transactions", 
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public TransactionResponseDTO getTransactionsOfBankA(@PathVariable String accountId) {
        return service.getBancoATransactions();
    }


    @GetMapping(
        value = "/bankB/accounts/{accountId}/transactions", 
    produces = MediaType.APPLICATION_JSON_VALUE
    )
    public TransactionResponseDTO getTransactionsOfBankB(@PathVariable String accountId) {
        
        return service.getBancoBTransactions();
    }
}

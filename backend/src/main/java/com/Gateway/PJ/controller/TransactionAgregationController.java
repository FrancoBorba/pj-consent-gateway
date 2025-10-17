package com.Gateway.PJ.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Gateway.PJ.controller.docs.TransactionAgregationControllerDocs;
import com.Gateway.PJ.dto.TransactionDataDTO;
import com.Gateway.PJ.dto.TransactionResponseDTO;
import com.Gateway.PJ.service.AggregationService;

@RestController()
@RequestMapping("/api/v1")
public class TransactionAgregationController implements TransactionAgregationControllerDocs{

    @Autowired
    private AggregationService service;

    @Override
    @GetMapping(
        value = {"/transactions"},
        produces = {
            MediaType.APPLICATION_JSON_VALUE
        }
    )
    public List<TransactionDataDTO> transaction() {
        return service.aggregateTransactions();
    }
    
}

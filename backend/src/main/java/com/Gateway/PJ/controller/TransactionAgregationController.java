package com.Gateway.PJ.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Gateway.PJ.controller.docs.TransactionAgregationControllerDocs;
import com.Gateway.PJ.dto.TransactionDataDTO;
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
    public ResponseEntity<Page<TransactionDataDTO>> transaction(
             @RequestParam String userId,
        @RequestParam(value = "page" , defaultValue = "0") Integer page,
        @RequestParam(value = "size" , defaultValue = "10") Integer size
    ) {

     Pageable pageable = PageRequest.of(page, size);
   
    return ResponseEntity.ok(service.aggregateTransactions(userId , pageable));
    }
    
}

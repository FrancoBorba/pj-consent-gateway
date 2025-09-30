package com.Gateway.PJ.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.Gateway.PJ.dto.TransactionResponseDTO;

@SpringBootTest
public class MockDataServiceTest {
    

        @Autowired
    private MockDataService mockDataService;


    @BeforeEach
    void setUp(){
        
    }

    @Test
    public void whenCallGetBancoA_ShouldReturnSuccesullTransaction(){

        
    TransactionResponseDTO resultado = mockDataService.getBancoATransactions();

    assertNotNull(resultado);

    assertNotNull(resultado.getData());

    assertEquals(10, resultado.getMeta().getTotalRecords());

    assertEquals("TXITA001", resultado.getData().get(0).getTransactionId());
    }


}

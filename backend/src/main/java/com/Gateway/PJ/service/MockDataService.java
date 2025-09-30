package com.Gateway.PJ.service;

import java.io.IOException;
import java.io.InputStream;
import com.Gateway.PJ.dto.TransactionResponseDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import org.slf4j.Logger;

import org.springframework.stereotype.Service;

@Service
public class MockDataService {

       private final Logger logger = org.slf4j.LoggerFactory.getLogger(MockDataService.class.getName());
    private final ObjectMapper mapper;
    
        public MockDataService(ObjectMapper mapper) { // Injeção via construtor
        this.mapper = mapper;
    }
    
    public TransactionResponseDTO getBancoATransactions() {
      
        return readJsonFile("/mocks/mock-banco-a.json");
    }

    public TransactionResponseDTO getBancoBTransactions() {
        
        return readJsonFile("/mocks/mock-banco-b.json");
    }

    private TransactionResponseDTO readJsonFile(String filePath) {
        logger.info("Reading mock file from {}", filePath);
        TypeReference<TransactionResponseDTO> typeReference = new TypeReference<>() {};
        
        
        InputStream inputStream = MockDataService.class.getResourceAsStream(filePath);

        try {
            if (inputStream == null) {
              
                throw new IOException("File not found in classpath " + filePath);
            }
            
            return mapper.readValue(inputStream, typeReference);
        } catch (IOException e) {
            logger.error("Could not read the file: {}", e.getMessage());
            return null; 
        }
    }
}

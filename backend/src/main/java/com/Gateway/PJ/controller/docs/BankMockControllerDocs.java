package com.Gateway.PJ.controller.docs;



import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;

import com.Gateway.PJ.dto.TransactionResponseDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Banks " , description = "Take the transactions of the banks")
public interface BankMockControllerDocs {
    
     @Operation(
    summary = "Find transaction in Bank B",
    description = "This endpoint returns all transactions from a simulated bank " ,
    responses = {
         @ApiResponse(description = "Success" , responseCode = "200" ,
     content = {
      @Content( mediaType = MediaType.APPLICATION_JSON_VALUE,
          schema = @Schema(implementation = TransactionResponseDTO.class))}),
      @ApiResponse(description = "No content" , responseCode = "204" , content = @Content),
      @ApiResponse(description = "Bad request" , responseCode = "400" , content = @Content),
      @ApiResponse(description = "Unatorizhed" , responseCode = "401" , content = @Content),
      @ApiResponse(description = "Not found" , responseCode = "404" , content = @Content),
      @ApiResponse(description = "Internal server error" , responseCode = "500", content = @Content)
    }
  )
   public TransactionResponseDTO getTransactionsOfBankB(@PathVariable String accountId);
    
     @Operation(
    summary = "Find transaction in Bank A",
        description = "This endpoint returns all transactions from a simulated bank " ,
    responses = {
         @ApiResponse(description = "Success" , responseCode = "200" ,
     content = {
      @Content( mediaType = MediaType.APPLICATION_JSON_VALUE,
          schema = @Schema(implementation = TransactionResponseDTO.class))}),
      @ApiResponse(description = "No content" , responseCode = "204" , content = @Content),
      @ApiResponse(description = "Bad request" , responseCode = "400" , content = @Content),
      @ApiResponse(description = "Unatorizhed" , responseCode = "401" , content = @Content),
      @ApiResponse(description = "Not found" , responseCode = "404" , content = @Content),
      @ApiResponse(description = "Internal server error" , responseCode = "500", content = @Content)
    }
  )
       public TransactionResponseDTO getTransactionsOfBankA(@PathVariable String accountId);
}

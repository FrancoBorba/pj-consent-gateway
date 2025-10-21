package com.Gateway.PJ.controller.docs;


import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import com.Gateway.PJ.dto.TransactionDataDTO;
import com.Gateway.PJ.dto.TransactionResponseDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;




@Tag(name = "Agregration" , description = "Call all transactions of all banks with one call")
public interface TransactionAgregationControllerDocs {
    
     @Operation(

summary = "Get all transactions",

description = "This endpoint returns all transactions from all bancks , in the future will be all transaction of a Person " ,

responses = {

@ApiResponse(description = "Success" , responseCode = "200" ,

content = {

@Content( mediaType = MediaType.APPLICATION_JSON_VALUE,

array = @ArraySchema(schema = @Schema(implementation = TransactionResponseDTO.class)))}),

@ApiResponse(description = "No content" , responseCode = "204" , content = @Content),

@ApiResponse(description = "Bad request" , responseCode = "400" , content = @Content),

@ApiResponse(description = "Unatorizhed" , responseCode = "401" , content = @Content),

@ApiResponse(description = "Not found" , responseCode = "404" , content = @Content),

@ApiResponse(description = "Internal server error" , responseCode = "500", content = @Content)

}
) 
    public ResponseEntity<Page<TransactionDataDTO>> transaction(
        @RequestParam String userId,
        @RequestParam(value = "page" , defaultValue = "0") 
        @Min(value = 0 , message = "The page must be 0 or hight")
        Integer page,
        @RequestParam(value = "size" , defaultValue = "10") 
        @Max(value = 100 , message = "The max itens in a page must be 100")
        Integer size
        );
}

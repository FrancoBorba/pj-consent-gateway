package com.Gateway.PJ.controller.docs;

import java.util.List;

import com.Gateway.PJ.dto.TransactionDataDTO;
import com.Gateway.PJ.dto.TransactionResponseDTO;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Agregration" , description = "Call all transactions of all banks with one call")
public interface TransactionAgregationControllerDocs {
    

    public List<TransactionDataDTO> transaction();
}

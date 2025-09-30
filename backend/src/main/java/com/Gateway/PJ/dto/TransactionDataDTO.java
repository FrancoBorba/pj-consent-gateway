package com.Gateway.PJ.dto;

import java.time.LocalDateTime;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import com.Gateway.PJ.enuns.PaymentType;


/**
 * Represents the detailed data of a single financial transaction.
 */
public class TransactionDataDTO {

    @NotBlank
    private String transactionId;

    @NotBlank
    private String completedAuthorisedPaymentType;

    @NotBlank
    private String creditDebitType;

    @NotBlank
    private String transactionName;

    @NotNull
    private PaymentType type; 

    @NotNull
    
    private AmountDTO transactionAmount; // amount and currency

    @NotNull
    private PartieDTO partie; // Other partie Object

    @NotNull

    private LocalDateTime transactionDateTime;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getCompletedAuthorisedPaymentType() {
        return completedAuthorisedPaymentType;
    }

    public void setCompletedAuthorisedPaymentType(String completedAuthorisedPaymentType) {
        this.completedAuthorisedPaymentType = completedAuthorisedPaymentType;
    }

    public String getCreditDebitType() {
        return creditDebitType;
    }

    public void setCreditDebitType(String creditDebitType) {
        this.creditDebitType = creditDebitType;
    }

    public String getTransactionName() {
        return transactionName;
    }

    public void setTransactionName(String transactionName) {
        this.transactionName = transactionName;
    }

    public PaymentType getType() {
        return type;
    }

    public void setType(PaymentType type) {
        this.type = type;
    }

    public AmountDTO getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(AmountDTO transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public PartieDTO getPartie() {
        return partie;
    }

    public void setPartie(PartieDTO partie) {
        this.partie = partie;
    }

    public LocalDateTime getTransactionDateTime() {
        return transactionDateTime;
    }

    public void setTransactionDateTime(LocalDateTime transactionDateTime) {
        this.transactionDateTime = transactionDateTime;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((transactionId == null) ? 0 : transactionId.hashCode());
        result = prime * result
                + ((completedAuthorisedPaymentType == null) ? 0 : completedAuthorisedPaymentType.hashCode());
        result = prime * result + ((creditDebitType == null) ? 0 : creditDebitType.hashCode());
        result = prime * result + ((transactionName == null) ? 0 : transactionName.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + ((transactionAmount == null) ? 0 : transactionAmount.hashCode());
        result = prime * result + ((partie == null) ? 0 : partie.hashCode());
        result = prime * result + ((transactionDateTime == null) ? 0 : transactionDateTime.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TransactionDataDTO other = (TransactionDataDTO) obj;
        if (transactionId == null) {
            if (other.transactionId != null)
                return false;
        } else if (!transactionId.equals(other.transactionId))
            return false;
        if (completedAuthorisedPaymentType == null) {
            if (other.completedAuthorisedPaymentType != null)
                return false;
        } else if (!completedAuthorisedPaymentType.equals(other.completedAuthorisedPaymentType))
            return false;
        if (creditDebitType == null) {
            if (other.creditDebitType != null)
                return false;
        } else if (!creditDebitType.equals(other.creditDebitType))
            return false;
        if (transactionName == null) {
            if (other.transactionName != null)
                return false;
        } else if (!transactionName.equals(other.transactionName))
            return false;
        if (type != other.type)
            return false;
        if (transactionAmount == null) {
            if (other.transactionAmount != null)
                return false;
        } else if (!transactionAmount.equals(other.transactionAmount))
            return false;
        if (partie == null) {
            if (other.partie != null)
                return false;
        } else if (!partie.equals(other.partie))
            return false;
        if (transactionDateTime == null) {
            if (other.transactionDateTime != null)
                return false;
        } else if (!transactionDateTime.equals(other.transactionDateTime))
            return false;
        return true;
    }

}
package com.Gateway.PJ.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

//Represents the other party to the transaction ( )
public class PartieDTO {
    
    @NotBlank
    String partieCnpjCpf;

    // Fisica ou Juridica
    @NotBlank
    String partiePersonType;

    // Identify the Bank Ex: Nubank 260
    @NotNull
    String partieCompeCode;

    // It is the number of the other party's bank branch.
    @NotNull
    String partieBranchCode;

    //Phone Number
    @NotBlank
    String partieNumber;

    //It is the account verification digit
    @NotNull
    String partieCheckDigit;

    public String getPartieCnpjCpf() {
        return partieCnpjCpf;
    }

    public void setPartieCnpjCpf(String partieCnpjCpf) {
        this.partieCnpjCpf = partieCnpjCpf;
    }

    public String getPartiePersonType() {
        return partiePersonType;
    }

    public void setPartiePersonType(String partiePersonType) {
        this.partiePersonType = partiePersonType;
    }

    public String getPartieCompeCode() {
        return partieCompeCode;
    }

    public void setPartieCompeCode(String partieCompeCode) {
        this.partieCompeCode = partieCompeCode;
    }

    public String getPartieBranchCode() {
        return partieBranchCode;
    }

    public void setPartieBranchCode(String partieBranchCode) {
        this.partieBranchCode = partieBranchCode;
    }

    public String getPartieNumber() {
        return partieNumber;
    }

    public void setPartieNumber(String partieNumber) {
        this.partieNumber = partieNumber;
    }

    public String getPartieCheckDigit() {
        return partieCheckDigit;
    }

    public void setPartieCheckDigit(String partieCheckDigit) {
        this.partieCheckDigit = partieCheckDigit;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((partieCnpjCpf == null) ? 0 : partieCnpjCpf.hashCode());
        result = prime * result + ((partiePersonType == null) ? 0 : partiePersonType.hashCode());
        result = prime * result + ((partieCompeCode == null) ? 0 : partieCompeCode.hashCode());
        result = prime * result + ((partieBranchCode == null) ? 0 : partieBranchCode.hashCode());
        result = prime * result + ((partieNumber == null) ? 0 : partieNumber.hashCode());
        result = prime * result + ((partieCheckDigit == null) ? 0 : partieCheckDigit.hashCode());
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
        PartieDTO other = (PartieDTO) obj;
        if (partieCnpjCpf == null) {
            if (other.partieCnpjCpf != null)
                return false;
        } else if (!partieCnpjCpf.equals(other.partieCnpjCpf))
            return false;
        if (partiePersonType == null) {
            if (other.partiePersonType != null)
                return false;
        } else if (!partiePersonType.equals(other.partiePersonType))
            return false;
        if (partieCompeCode == null) {
            if (other.partieCompeCode != null)
                return false;
        } else if (!partieCompeCode.equals(other.partieCompeCode))
            return false;
        if (partieBranchCode == null) {
            if (other.partieBranchCode != null)
                return false;
        } else if (!partieBranchCode.equals(other.partieBranchCode))
            return false;
        if (partieNumber == null) {
            if (other.partieNumber != null)
                return false;
        } else if (!partieNumber.equals(other.partieNumber))
            return false;
        if (partieCheckDigit == null) {
            if (other.partieCheckDigit != null)
                return false;
        } else if (!partieCheckDigit.equals(other.partieCheckDigit))
            return false;
        return true;
    }

   



  

}

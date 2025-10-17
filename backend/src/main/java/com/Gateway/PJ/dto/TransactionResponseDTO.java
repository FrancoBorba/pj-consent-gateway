package com.Gateway.PJ.dto;

import java.util.List;
import jakarta.validation.constraints.NotNull;

/**
 * Represents the top-level response object for a list of account transactions,
 * as specified by the Open Finance Brasil standard. This class acts as an
 * "envelope" containing the transaction data, pagination links, and metadata.
 */
public class TransactionResponseDTO {

    @NotNull
    private List<TransactionDataDTO> data;

    @NotNull
    private LinksDTO links;

    @NotNull
    private MetaDTO meta;

    // Getters and Setters

    public List<TransactionDataDTO> getData() {
        return data;
    }

    public void setData(List<TransactionDataDTO> data) {
        this.data = data;
    }

    public LinksDTO getLinks() {
        return links;
    }

    public void setLinks(LinksDTO links) {
        this.links = links;
    }

    public MetaDTO getMeta() {
        return meta;
    }

    public void setMeta(MetaDTO meta) {
        this.meta = meta;
    }

    // hashCode and equals

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((data == null) ? 0 : data.hashCode());
        result = prime * result + ((links == null) ? 0 : links.hashCode());
        result = prime * result + ((meta == null) ? 0 : meta.hashCode());
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
        TransactionResponseDTO other = (TransactionResponseDTO) obj;
        if (data == null) {
            if (other.data != null)
                return false;
        } else if (!data.equals(other.data))
            return false;
        if (links == null) {
            if (other.links != null)
                return false;
        } else if (!links.equals(other.links))
            return false;
        if (meta == null) {
            if (other.meta != null)
                return false;
        } else if (!meta.equals(other.meta))
            return false;
        return true;
    }

    /**
     * Inner class representing the pagination links in the API response.
     */
    public static class LinksDTO {
        private String self;
        private String first;
        private String prev;
        private String next;
        private String last;

        // Getters, setters for all fields...
        public String getSelf() { return self; }
        public void setSelf(String self) { this.self = self; }
        public String getFirst() { return first; }
        public void setFirst(String first) { this.first = first; }
        public String getPrev() { return prev; }
        public void setPrev(String prev) { this.prev = prev; }
        public String getNext() { return next; }
        public void setNext(String next) { this.next = next; }
        public String getLast() { return last; }
        public void setLast(String last) { this.last = last; }
    }

    /**
     * Inner class representing the metadata of the API response.
     */
    public static class MetaDTO {
        private int totalRecords;
        private int totalPages;

        // Getters, setters for all fields...
        public int getTotalRecords() { return totalRecords; }
        public void setTotalRecords(int totalRecords) { this.totalRecords = totalRecords; }
        public int getTotalPages() { return totalPages; }
        public void setTotalPages(int totalPages) { this.totalPages = totalPages; }
    }
}
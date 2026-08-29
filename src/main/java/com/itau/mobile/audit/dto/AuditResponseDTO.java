package com.itau.mobile.audit.dto;

import com.itau.mobile.audit.model.TransactionStatus;
import java.time.LocalDateTime;

public class AuditResponseDTO {

    private String transactionId;
    private TransactionStatus status;
    private String details;
    private LocalDateTime timestamp;

    public AuditResponseDTO(String transactionId, TransactionStatus status, String details) {
        this.transactionId = transactionId;
        this.status = status;
        this.details = details;
        this.timestamp = LocalDateTime.now();
    }

    public String getTransactionId() { return transactionId; }
    public TransactionStatus getStatus() { return status; }
    public String getDetails() { return details; }
    public LocalDateTime getTimestamp() { return timestamp; }
}

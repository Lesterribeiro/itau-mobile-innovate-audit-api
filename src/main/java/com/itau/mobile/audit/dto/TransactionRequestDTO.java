package com.itau.mobile.audit.dto;

import java.math.BigDecimal;

public class TransactionRequestDTO {

    private String transactionId;
    private String customerCpf;
    private BigDecimal amount;
    private String deviceToken;
    private String requestSignature;

    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }

    public String getCustomerCpf() { return customerCpf; }
    public void setCustomerCpf(String customerCpf) { this.customerCpf = customerCpf; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public String getDeviceToken() { return deviceToken; }
    public void setDeviceToken(String deviceToken) { this.deviceToken = deviceToken; }

    public String getRequestSignature() { return requestSignature; }
    public void setRequestSignature(String requestSignature) { this.requestSignature = requestSignature; }
}

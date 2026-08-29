package com.itau.mobile.audit.service.strategy;

import com.itau.mobile.audit.dto.TransactionRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class SecurityValidationStrategy implements AuditValidationStrategy {

    @Override
    public boolean validate(TransactionRequestDTO transaction) {
        if (transaction.getDeviceToken() == null || transaction.getRequestSignature() == null) {
            return false;
        }
        return transaction.getRequestSignature().startsWith("SIG_SECURE_");
    }

    @Override
    public String getErrorMessage() {
        return "Falha de seguranca: Requisicao sem assinatura valida ou origem nao autorizada.";
    }
}

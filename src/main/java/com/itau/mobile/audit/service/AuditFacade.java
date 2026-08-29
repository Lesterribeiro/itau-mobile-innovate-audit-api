package com.itau.mobile.audit.service;

import com.itau.mobile.audit.dto.AuditResponseDTO;
import com.itau.mobile.audit.dto.TransactionRequestDTO;
import com.itau.mobile.audit.model.TransactionStatus;
import com.itau.mobile.audit.service.strategy.CustomerValidationStrategy;
import com.itau.mobile.audit.service.strategy.SecurityValidationStrategy;
import com.itau.mobile.audit.util.AuditLoggerSingleton;
import org.springframework.stereotype.Service;

@Service
public class AuditFacade {

    private final CustomerValidationStrategy customerValidationStrategy;
    private final SecurityValidationStrategy securityValidationStrategy;

    public AuditFacade(CustomerValidationStrategy customerValidationStrategy,
                       SecurityValidationStrategy securityValidationStrategy) {
        this.customerValidationStrategy = customerValidationStrategy;
        this.securityValidationStrategy = securityValidationStrategy;
    }

    public AuditResponseDTO processAudit(TransactionRequestDTO transaction) {
        AuditLoggerSingleton logger = AuditLoggerSingleton.getInstance();

        if (!securityValidationStrategy.validate(transaction)) {
            logger.logAudit(transaction.getTransactionId(), "REJEITADO_SEGURANCA");
            return new AuditResponseDTO(
                    transaction.getTransactionId(),
                    TransactionStatus.REJECTED_SECURITY_FAIL,
                    securityValidationStrategy.getErrorMessage()
            );
        }

        if (!customerValidationStrategy.validate(transaction)) {
            logger.logAudit(transaction.getTransactionId(), "REJEITADO_CLIENTE_INVALIDO");
            return new AuditResponseDTO(
                    transaction.getTransactionId(),
                    TransactionStatus.REJECTED_UNREGISTERED_CLIENT,
                    customerValidationStrategy.getErrorMessage()
            );
        }

        logger.logAudit(transaction.getTransactionId(), "APROVADO");
        return new AuditResponseDTO(
                transaction.getTransactionId(),
                TransactionStatus.APPROVED,
                "Operacao auditada e validada com sucesso."
        );
    }
}

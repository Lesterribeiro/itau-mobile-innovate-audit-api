package com.itau.mobile.audit.controller;

import com.itau.mobile.audit.dto.AuditResponseDTO;
import com.itau.mobile.audit.dto.TransactionRequestDTO;
import com.itau.mobile.audit.service.AuditFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/audit")
public class AuditController {

    private final AuditFacade auditFacade;

    public AuditController(AuditFacade auditFacade) {
        this.auditFacade = auditFacade;
    }

    @PostMapping("/validate-transaction")
    public ResponseEntity<AuditResponseDTO> validateTransaction(@RequestBody TransactionRequestDTO transaction) {
        AuditResponseDTO response = auditFacade.processAudit(transaction);
        return ResponseEntity.ok(response);
    }
}

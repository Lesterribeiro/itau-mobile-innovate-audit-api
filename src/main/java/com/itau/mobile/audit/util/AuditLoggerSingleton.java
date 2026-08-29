package com.itau.mobile.audit.util;

import java.time.LocalDateTime;

public class AuditLoggerSingleton {

    private static AuditLoggerSingleton instance;

    private AuditLoggerSingleton() {}

    public static synchronized AuditLoggerSingleton getInstance() {
        if (instance == null) {
            instance = new AuditLoggerSingleton();
        }
        return instance;
    }

    public void logAudit(String transactionId, String message) {
        System.out.println("[AUDIT LOG - " + LocalDateTime.now() + "] TX: " + transactionId + " | Status: " + message);
    }
}

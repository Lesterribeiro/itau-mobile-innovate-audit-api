package com.itau.mobile.audit.service.strategy;

import com.itau.mobile.audit.dto.TransactionRequestDTO;
import com.itau.mobile.audit.repository.CustomerRepository;
import org.springframework.stereotype.Component;

@Component
public class CustomerValidationStrategy implements AuditValidationStrategy {

    private final CustomerRepository customerRepository;

    public CustomerValidationStrategy(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public boolean validate(TransactionRequestDTO transaction) {
        if (transaction.getCustomerCpf() == null || transaction.getCustomerCpf().isBlank()) {
            return false;
        }
        return customerRepository.findByCpfAndActiveAccountTrue(transaction.getCustomerCpf()).isPresent();
    }

    @Override
    public String getErrorMessage() {
        return "Cliente nao localizado na base de dados ou conta inativa.";
    }
}

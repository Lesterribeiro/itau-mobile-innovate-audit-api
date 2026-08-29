package com.itau.mobile.audit;

import com.itau.mobile.audit.model.Customer;
import com.itau.mobile.audit.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AuditApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuditApiApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(CustomerRepository repository) {
        return args -> {
            repository.save(new Customer("12345678900", "Cliente Cadastrado Exemplo", true));
            repository.save(new Customer("98765432100", "Cliente Inativo Exemplo", false));
        };
    }
}

package com.itau.mobile.audit.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_customers")
public class Customer {

    @Id
    private String cpf;
    private String name;
    private boolean activeAccount;

    public Customer() {}

    public Customer(String cpf, String name, boolean activeAccount) {
        this.cpf = cpf;
        this.name = name;
        this.activeAccount = activeAccount;
    }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public boolean isActiveAccount() { return activeAccount; }
    public void setActiveAccount(boolean activeAccount) { this.activeAccount = activeAccount; }
}

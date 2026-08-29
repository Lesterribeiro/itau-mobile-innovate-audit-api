# Itaú Mobile Innovate - Audit API

API REST desenvolvida com Spring Boot e Java 17 para auditoria transacional e validação de segurança no canal mobile.

## Arquitetura e Padrões de Projeto

A aplicação foi estruturada utilizando a arquitetura em camadas e três padrões de projeto clássicos (GoF):

1. **Singleton (`AuditLoggerSingleton`)**
   Centraliza o registro de logs de auditoria em uma única instância gerenciada na memória.

2. **Strategy (`AuditValidationStrategy`)**
   Interface que define o contrato de validação das transações. Implementada pelas classes `CustomerValidationStrategy` (validação de cadastro) e `SecurityValidationStrategy` (validação de assinatura e token do dispositivo).

3. **Facade (`AuditFacade`)**
   Serviço que unifica a execução das estratégias de validação e o registro de logs, disponibilizando um ponto único de entrada para a camada de controle (`AuditController`).

## Tecnologias Utilizadas

* Java 17
* Spring Boot 3
* Spring Data JPA
* H2 Database (banco de dados em memória)
* Apache Maven

## Endpoints

* **POST** `/api/v1/audit/validate-transaction`
  Valida a integridade da requisição mobile e retorna o status da auditoria (APPROVED, REJECTED_SECURITY_FAIL ou REJECTED_UNREGISTERED_CLIENT).

## Execução

```bash
mvn spring-boot:run

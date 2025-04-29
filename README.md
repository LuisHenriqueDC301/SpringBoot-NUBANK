# Desafio Backend Nubank: Gerenciamento de Clientes e Contatos

Este projeto consiste na construção de uma API REST para o gerenciamento de clientes e seus respectivos contatos. Cada cliente pode possuir um ou mais contatos associados.

## Requisitos Técnicos

A aplicação deve implementar as seguintes funcionalidades:

* **Cadastro de Cliente (POST /clientes):** Endpoint para criar novos registros de clientes.
* **Cadastro de Contato (POST /contatos):** Endpoint para adicionar um novo contato, associado a um cliente existente.
* **Listagem de todos os clientes com seus contatos (GET /clientes):** Endpoint para recuperar a lista completa de clientes, incluindo seus contatos.
* **Listagem de contatos de um cliente específico (GET /clientes/{id}/contatos):** Endpoint para obter os contatos de um cliente específico, identificado pelo seu ID.
* **Uso de Spring Boot + Spring Data JPA:** Framework Java para desenvolvimento rápido e fácil de aplicações Spring, utilizando o JPA para persistência de dados.
* **Banco de dados PostgreSQL:** Sistema de gerenciamento de banco de dados relacional robusto e popular.
* **Entidades Cliente e Contato com relacionamento OneToMany / ManyToOne:** Modelagem do relacionamento entre clientes e contatos no banco de dados.

## Requisitos de Código

O código desenvolvido deve seguir boas práticas de programação, incluindo:

* **Separação de responsabilidades (camadas: controller, service, repository):** Organização do código em camadas lógicas para melhor manutenção e escalabilidade.
* **Uso de DTOs para entrada e saída de dados:** Utilização de Data Transfer Objects para a transferência de informações entre as camadas da aplicação e a API.
* **Tratamento adequado de erros:** Implementação de mecanismos para identificar e tratar erros de forma clara e informativa para o consumidor da API.
* **Usar Lombok:** Biblioteca Java para reduzir a quantidade de código boilerplate, como getters, setters e construtores.

## Diferenciais Adicionais

Este projeto inclui a configuração de um ambiente de desenvolvimento simplificado através do Docker Compose:

* **Utilização de Docker Compose:** Um arquivo `docker-compose.yml` é fornecido para facilitar a criação e o gerenciamento de um ambiente isolado contendo a aplicação Spring Boot, o banco de dados PostgreSQL e a ferramenta de administração pgAdmin. Isso simplifica a configuração e execução do projeto em diferentes ambientes.

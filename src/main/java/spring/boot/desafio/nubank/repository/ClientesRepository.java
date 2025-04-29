package spring.boot.desafio.nubank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.boot.desafio.nubank.model.Cliente;

public interface ClientesRepository extends JpaRepository<Cliente, Long> {
    
}

package spring.boot.desafio.nubank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.boot.desafio.nubank.dto.ClientesDTO;
import spring.boot.desafio.nubank.dto.ClientesResponseDTO;
import spring.boot.desafio.nubank.dto.ContatoResponseDTO;
import spring.boot.desafio.nubank.model.Cliente;
import spring.boot.desafio.nubank.service.ClientesService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/clientes")
public class ClientesController {
    
    @Autowired
    private ClientesService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> criar(@RequestBody ClientesDTO dto) {
        //TODO: process POST request

        Cliente clienteSalvo = clienteService.salvarCliente(dto);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
    }

    @GetMapping
    public ResponseEntity<List<ClientesResponseDTO>> listarTodos() {
        return ResponseEntity.ok(clienteService.listarTodos());
    }
    
    @GetMapping("/{id}/contatos")
    public ResponseEntity<List<ContatoResponseDTO>> listarConatos(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.listarContatoPorCliente(id));
    }
    
}

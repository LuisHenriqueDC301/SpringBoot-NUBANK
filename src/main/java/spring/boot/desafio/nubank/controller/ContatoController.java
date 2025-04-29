package spring.boot.desafio.nubank.controller;

import java.lang.StackWalker.Option;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.boot.desafio.nubank.dto.ContatoDTO;
import spring.boot.desafio.nubank.model.Cliente;
import spring.boot.desafio.nubank.model.Contato;
import spring.boot.desafio.nubank.repository.ClientesRepository;
import spring.boot.desafio.nubank.repository.ContatosRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/contatos")
public class ContatoController {
    @Autowired
    private ContatosRepository contatosRepository;
    
    @Autowired
    private ClientesRepository clientesRepository;

    @PostMapping()
    public ResponseEntity<?> criar(@RequestBody ContatoDTO dto) {
        //TODO: process POST request
        Optional<Cliente> clientesopt = clientesRepository.findById(dto.getClienteID());
        
        if(clientesopt.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cliente nao encontrado");
        }

        Contato contato = new Contato();
        contato.setTelefone(dto.getTelefone());
        contato.setEmail(dto.getEmail());
        contato.setCliente(clientesopt.get());
        contatosRepository.save(contato);

        return ResponseEntity.status(HttpStatus.CREATED).body(contato);
    }
    
}

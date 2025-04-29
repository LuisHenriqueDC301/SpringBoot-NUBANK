package spring.boot.desafio.nubank.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.boot.desafio.nubank.dto.ClientesDTO;
import spring.boot.desafio.nubank.dto.ClientesResponseDTO;
import spring.boot.desafio.nubank.dto.ContatoResponseDTO;
import spring.boot.desafio.nubank.model.Cliente;
import spring.boot.desafio.nubank.model.Contato;
import spring.boot.desafio.nubank.repository.ClientesRepository;

@Service
public class ClientesService {

    @Autowired
    private ClientesRepository clientesRepository;

    public Cliente salvarCliente(ClientesDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());

        if (dto.getContatos() != null && dto.getContatos().size() > 0) {
            List<Contato> contatos = dto.getContatos().stream().map(c -> {
                Contato contato = new Contato();
                contato.setTelefone(c.getTelefone());
                contato.setEmail(c.getEmail());
                contato.setCliente(cliente);
                return contato;
            }).collect(Collectors.toList());
            cliente.setContatos(contatos);
        }

        return clientesRepository.save(cliente);
    }

    
    public List<ContatoResponseDTO> listarContatoPorCliente(Long id){
        Cliente cliente = clientesRepository.findById(id).orElseThrow(()-> new RuntimeException("Cliente não encontrado"));

        return cliente.getContatos().stream().map(c -> {
            ContatoResponseDTO contato = new ContatoResponseDTO();
            contato.setId(c.getId());
            contato.setTelefone(c.getTelefone());
            contato.setEmail(c.getEmail());
            return contato;
        }).collect(Collectors.toList());
        
    }

    public List<ClientesResponseDTO> listarTodos(){
        return clientesRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    private ClientesResponseDTO toDto(Cliente cliente) {
        ClientesResponseDTO dto = new ClientesResponseDTO();
        dto.setId(cliente.getId());
        dto.setNome(cliente.getNome());

        List<ContatoResponseDTO> contatos = cliente.getContatos().stream().map(c -> {
            ContatoResponseDTO contato = new ContatoResponseDTO();
            contato.setId(c.getId());
            contato.setTelefone(c.getTelefone());
            contato.setEmail(c.getEmail());
            return contato;
        }).collect(Collectors.toList());

        dto.setContatos(contatos);
        return dto;
    }
}

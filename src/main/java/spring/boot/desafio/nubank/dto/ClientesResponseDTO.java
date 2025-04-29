package spring.boot.desafio.nubank.dto;
import java.util.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientesResponseDTO {
    
    private Long id;
    private String nome;
    private List<ContatoResponseDTO> contatos;
}

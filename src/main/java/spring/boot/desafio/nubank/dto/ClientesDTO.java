package spring.boot.desafio.nubank.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientesDTO {
    private String nome;
    private List<ContatoDTO> contatos;
}

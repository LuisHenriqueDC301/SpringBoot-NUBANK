package spring.boot.desafio.nubank.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContatoDTO {
    private String nome;
    private String email;
    private String telefone;
    private long ClienteID;
}

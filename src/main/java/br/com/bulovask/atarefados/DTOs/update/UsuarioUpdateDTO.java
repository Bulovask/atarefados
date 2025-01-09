package br.com.bulovask.atarefados.DTOs.update;

import br.com.bulovask.atarefados.DTOs.BaseDTO;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsuarioUpdateDTO extends BaseDTO {
    Long id;
    String nome;
    @Size(min = 5)
    String senha;
    String hashsenha;
}

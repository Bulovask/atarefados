package br.com.bulovask.atarefados.DTOs.read;

import br.com.bulovask.atarefados.DTOs.BaseDTO;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UsuarioDTO extends BaseDTO {
    Long id;
    String nome;
    String email;
    List<ProjetoLazyDTO> meusProjetos;
    List<ProjetoLazyDTO> outrosProjetos;
}

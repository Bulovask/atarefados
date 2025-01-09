package br.com.bulovask.atarefados.DTOs.read;

import br.com.bulovask.atarefados.DTOs.BaseDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor()
public class ProjetoLazyDTO extends BaseDTO {
    Long id;
    String nome;
    String dono;
}

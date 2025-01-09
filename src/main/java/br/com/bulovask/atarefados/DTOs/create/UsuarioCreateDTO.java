package br.com.bulovask.atarefados.DTOs.create;

import br.com.bulovask.atarefados.DTOs.BaseDTO;
import br.com.bulovask.atarefados.DTOs.read.ProjetoLazyDTO;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UsuarioCreateDTO extends BaseDTO {
    Long id;
    @NotNull(message = "O nome não pode ser nulo!")
    String nome;
    @NotNull(message = "O e-mail não pode ser nulo!")
    @Email(message = "O e-mail deve está em um formato válido!")
    String email;
    @NotNull(message = "A senha não pode ser nula!")
    @Size(min = 5)
    String senha;
    String hashsenha;
}

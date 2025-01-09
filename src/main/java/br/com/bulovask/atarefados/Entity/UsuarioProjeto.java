package br.com.bulovask.atarefados.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class UsuarioProjeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @NotNull
    private Usuario usuario;
    @ManyToOne
    @NotNull
    private Projeto projeto;
}

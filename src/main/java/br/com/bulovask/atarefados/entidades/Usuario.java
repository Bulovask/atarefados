package br.com.bulovask.atarefados.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String nome;
    @NotNull
    private String email;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
    private List<UsuarioProjeto> projetos;

    public void setId(Long id) {
    }
}

package br.com.bulovask.atarefados.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String nome;

    @ManyToOne
    @NotNull

    private Usuario usuarioDono;

    @OneToMany (fetch = FetchType.LAZY, mappedBy = "projeto")
    private List<Lista> listas;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "projeto")
    private List<UsuarioProjeto> colaboradores;
}

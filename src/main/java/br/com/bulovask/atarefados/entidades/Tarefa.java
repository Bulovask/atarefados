package br.com.bulovask.atarefados.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String nome;
    private String descricao;

    @ManyToOne
    @NotNull
    private Lista lista;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tarefa")
    private List<CategoriaTarefa> categorias;
}

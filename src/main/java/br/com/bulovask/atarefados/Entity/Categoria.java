package br.com.bulovask.atarefados.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String nome;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria")
    private List<CategoriaTarefa> tarefas;
}

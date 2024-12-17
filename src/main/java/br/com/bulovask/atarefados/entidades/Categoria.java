package br.com.bulovask.atarefados.entidades;

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

    @OneToMany
    private List<CategoriaTarefa> tarefas;

    public void setId(Long id) {
    }
}

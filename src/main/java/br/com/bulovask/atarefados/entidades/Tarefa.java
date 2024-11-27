package br.com.bulovask.atarefados.entidades;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;

    @ManyToOne
    private Lista lista;
    @OneToMany
    private List<CategoriaTarefa> categorias;
}

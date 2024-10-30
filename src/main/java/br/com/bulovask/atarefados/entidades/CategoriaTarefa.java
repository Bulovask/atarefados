package br.com.bulovask.atarefados.entidades;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CategoriaTarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "tarefa_id")
    private Tarefa tarefa;
}

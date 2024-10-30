package br.com.bulovask.atarefados.entidades;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    private LocalDate prazo;
    private LocalDate criadoEm;

    @OneToMany(mappedBy = "tarefaPai")
    private List<Anexo> anexos;

    @ManyToOne
    @JoinColumn(name = "lista_pai_id")
    private Lista listaPai;

    @ManyToOne
    @JoinColumn(name = "tarefa_pai_id")
    private Tarefa tarefaPai;

    @OneToMany(mappedBy = "tarefa")
    private List<CategoriaTarefa> categorias;

    @OneToMany(mappedBy = "tarefa")
    private List<ComentarioTarefa> comentarios;

    private Boolean statusConclusao;
}

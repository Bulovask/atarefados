package br.com.bulovask.atarefados.entidades;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ComentarioTarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario autor;
    @ManyToOne
    @JoinColumn(name = "tarefa_pai_id")
    private Tarefa tarefaPai;
    private String mensagem;
}

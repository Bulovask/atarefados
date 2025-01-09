package br.com.bulovask.atarefados.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Anexo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tarefa_id")
    private Tarefa tarefa;

    private String urlArquivo;
}

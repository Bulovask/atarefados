package br.com.bulovask.atarefados.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class ComentarioTarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensagem;
    @ManyToOne
    @NotNull
    private Usuario autor;
    @NotNull
    private LocalDate datahora;

    @ManyToOne
    @NotNull
    private Tarefa tarefa;
}

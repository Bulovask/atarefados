package br.com.bulovask.atarefados.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.File;

@Entity
@Data
public class Anexo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private File file;

    @ManyToOne
    private Tarefa tarefa;
}

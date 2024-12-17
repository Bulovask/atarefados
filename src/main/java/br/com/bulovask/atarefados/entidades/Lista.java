package br.com.bulovask.atarefados.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Lista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String nome;
    @ManyToOne
    @NotNull
    private Projeto projeto;

    public void setId(Long id) {
    }
}

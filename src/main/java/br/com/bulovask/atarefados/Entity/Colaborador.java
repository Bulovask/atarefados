package br.com.bulovask.atarefados.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Colaborador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "projeto_id")
    private Projeto projeto;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}

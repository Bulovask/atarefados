package br.com.bulovask.atarefados.entidades;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Lista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "lista_pai_id")
    private Lista listaPai;
}

package br.com.bulovask.atarefados.entidades;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @ManyToOne
    private Usuario usuarioDono;

    @OneToMany
    private List<Lista> listas;

    @OneToMany
    private List<UsuarioProjeto> colaboradores;
}

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
    private Usuario usuarioDono;
    @OneToMany(mappedBy = "projeto")
    private List<Colaborador> colaboradores;
}

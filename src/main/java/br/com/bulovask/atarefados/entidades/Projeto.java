package br.com.bulovask.atarefados.entidades;

import jakarta.persistence.*;
import lombok.Data;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Entity
@Data
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Usuario usuarioDono;

    @OneToMany
    private ArrayList<Lista> listas;

    @OneToMany
    private ArrayList<UsuarioProjeto> colaboradores;
}

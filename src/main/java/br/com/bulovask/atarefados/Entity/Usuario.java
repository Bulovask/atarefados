package br.com.bulovask.atarefados.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    @Transient
    private String senha;
    private String hashsenha;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
    private List<UsuarioProjeto> outrosProjetos;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuarioDono")
    private List<Projeto> meusProjetos;
}

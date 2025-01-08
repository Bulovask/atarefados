package br.com.bulovask.atarefados.entidades;

import com.fasterxml.jackson.annotation.JsonGetter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

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
//    @JsonBackReference
    private Projeto projeto;

    public void setId(Long id) {
    }

    @JsonGetter("projeto")  // Define como a propriedade 'projeto' será serializada
    public Map<String, Object> getProjetoInfo() {
        Map<String, Object> projetoInfo = new HashMap<>();
        projetoInfo.put("id", projeto.getId());
        projetoInfo.put("nome", projeto.getNome());
        return projetoInfo;
    }
}

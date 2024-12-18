package br.com.bulovask.atarefados.entidades;

import com.fasterxml.jackson.annotation.JsonGetter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Data
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String nome;

    @ManyToOne
    @NotNull

    private Usuario usuarioDono;

    @OneToMany (fetch = FetchType.LAZY, mappedBy = "projeto")
    private List<Lista> listas;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "projeto")
    private List<UsuarioProjeto> colaboradores;

    @JsonGetter("listas")  // Define como a propriedade 'projeto' será serializada
    public ArrayList<Map<String, Object>> getProjetoInfo() {

        ArrayList<Map<String, Object>> listasInfo = new ArrayList<>();
        for(int i = 0; i < listas.size(); i++) {
            Lista lista = listas.get(i);
            Map<String, Object> listaInfo = new HashMap<>();
            listaInfo.put("id", lista.getId());
            listaInfo.put("nome", lista.getNome());
            listasInfo.add(listaInfo);
        }
        return listasInfo;
    }
}

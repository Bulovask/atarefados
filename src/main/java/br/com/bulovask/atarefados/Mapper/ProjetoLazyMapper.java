package br.com.bulovask.atarefados.Mapper;

import br.com.bulovask.atarefados.DTOs.read.ProjetoLazyDTO;
import br.com.bulovask.atarefados.DTOs.read.UsuarioDTO;
import br.com.bulovask.atarefados.Entity.Projeto;
import br.com.bulovask.atarefados.Entity.UsuarioProjeto;
import br.com.bulovask.atarefados.Repository.ProjetoRepository;
import br.com.bulovask.atarefados.Repository.UsuarioProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProjetoLazyMapper {
    @Autowired
    ProjetoRepository projetoRepository;
    @Autowired
    UsuarioProjetoRepository usuarioProjetoRepository;

    public ProjetoLazyDTO toProjetoLazyDTO(Projeto projeto) {
        ProjetoLazyDTO dto = new ProjetoLazyDTO();

        dto.setId(projeto.getId());
        dto.setNome(projeto.getNome());
        dto.setDono(projeto.getUsuarioDono().getNome());
        return dto;
    }

    public ProjetoLazyDTO toProjetoLazyDTO(UsuarioProjeto projeto) {
        ProjetoLazyDTO dto = new ProjetoLazyDTO();

        dto.setId(projeto.getId());
        dto.setNome(projeto.getProjeto().getNome());
        dto.setDono(projeto.getProjeto().getUsuarioDono().getNome());
        return dto;
    }

    public Projeto toEntity(ProjetoLazyDTO dto) {
        return projetoRepository.findById(dto.getId()).orElseThrow();
    }

    public UsuarioProjeto toUsuarioProjetoEntity(ProjetoLazyDTO dto) {
        return usuarioProjetoRepository.findById(dto.getId()).orElseThrow();
    }
}

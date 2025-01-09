package br.com.bulovask.atarefados.Mapper;

import br.com.bulovask.atarefados.DTOs.create.UsuarioCreateDTO;
import br.com.bulovask.atarefados.DTOs.read.ProjetoLazyDTO;
import br.com.bulovask.atarefados.DTOs.read.UsuarioDTO;
import br.com.bulovask.atarefados.DTOs.update.UsuarioUpdateDTO;
import br.com.bulovask.atarefados.Entity.Projeto;
import br.com.bulovask.atarefados.Entity.Usuario;
import br.com.bulovask.atarefados.Entity.UsuarioProjeto;
import br.com.bulovask.atarefados.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsuarioMapper {
    @Autowired
    UsuarioRepository usuarioRepository;

    public UsuarioDTO toUsuarioDTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        ProjetoLazyMapper projetoLazyMapper = new ProjetoLazyMapper();

        dto.setId(usuario.getId());
        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());

        List<Projeto> meusProjetos = usuario.getMeusProjetos();
        List<UsuarioProjeto> outrosProjetos = usuario.getOutrosProjetos();

        List<ProjetoLazyDTO> meusProjetosLazyDTO = new ArrayList<>();
        List<ProjetoLazyDTO> outrosProjetosLazyDTO = new ArrayList<>();

        if(!(meusProjetos == null)) {
            for (Projeto projeto : meusProjetos) {
                meusProjetosLazyDTO.add(projetoLazyMapper.toProjetoLazyDTO(projeto));
            }
        }
        if(!(outrosProjetos == null)) {
            for (UsuarioProjeto projeto : outrosProjetos) {
                outrosProjetosLazyDTO.add(projetoLazyMapper.toProjetoLazyDTO(projeto));
            }
        }
        dto.setMeusProjetos(meusProjetosLazyDTO);
        dto.setOutrosProjetos(outrosProjetosLazyDTO);
        return dto;
    }

    public Usuario toEntity(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        ProjetoLazyMapper projetoLazyMapper = new ProjetoLazyMapper();

        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());

        List<ProjetoLazyDTO> meusProjetosLazyDTO = dto.getMeusProjetos();
        List<ProjetoLazyDTO> outrosProjetosLazyDTO = dto.getOutrosProjetos();

        List<Projeto> meusProjetos = new ArrayList<>() ;
        List<UsuarioProjeto> outrosProjetos = new ArrayList<>() ;

        if(!(meusProjetosLazyDTO == null)) {
            for (ProjetoLazyDTO projeto : meusProjetosLazyDTO) {
                meusProjetos.add(projetoLazyMapper.toEntity(projeto));
            }
        }

        if(!(outrosProjetosLazyDTO == null)) {
            for (ProjetoLazyDTO projeto : outrosProjetosLazyDTO) {
                outrosProjetos.add(projetoLazyMapper.toUsuarioProjetoEntity(projeto));
            }
        }

        usuario.setMeusProjetos(meusProjetos);
        usuario.setOutrosProjetos(outrosProjetos);
        return usuario;
    }

    public Usuario toEntity(UsuarioCreateDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());
        usuario.setHashsenha(dto.getHashsenha());
        return usuario;
    }

    public Usuario toEntity(UsuarioUpdateDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setId(dto.getId());
        usuario.setNome(dto.getNome());
        usuario.setSenha(dto.getSenha());
        usuario.setHashsenha(dto.getHashsenha());

        usuario.setEmail(usuarioRepository.findById(dto.getId()).orElseThrow().getEmail());

        return usuario;
    }
}
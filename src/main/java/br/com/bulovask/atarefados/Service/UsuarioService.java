package br.com.bulovask.atarefados.Service;

import br.com.bulovask.atarefados.DTOs.create.UsuarioCreateDTO;
import br.com.bulovask.atarefados.DTOs.read.UsuarioDTO;
import br.com.bulovask.atarefados.DTOs.update.UsuarioUpdateDTO;
import br.com.bulovask.atarefados.Mapper.UsuarioMapper;
import br.com.bulovask.atarefados.Repository.UsuarioRepository;
import br.com.bulovask.atarefados.Entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final BCryptPasswordEncoder bc;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper, BCryptPasswordEncoder bc) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
        this.bc = bc;
    }

    public UsuarioDTO salvar (UsuarioCreateDTO usuario){
        usuario.setHashsenha(bc.encode(usuario.getSenha()));
        return usuarioMapper.toUsuarioDTO(usuarioRepository.save(usuarioMapper.toEntity(usuario)));
    }

    public UsuarioDTO atualizar (Long id, UsuarioUpdateDTO usuario){
        Usuario usuarioOld = usuarioRepository.findById(id).orElseThrow();
        usuario.setId(id);

        if(usuario.getNome() == null) {usuario.setNome(usuarioOld.getNome());}
        if(usuario.getSenha() == null || usuario.getSenha().isBlank()) {
            usuario.setSenha("nao sera salva");
            usuario.setHashsenha(usuarioOld.getHashsenha());
        }
        else {
            usuario.setHashsenha(bc.encode(usuario.getSenha()));
        }

        return usuarioMapper.toUsuarioDTO(usuarioRepository.save(usuarioMapper.toEntity(usuario)));
    }

    public List<UsuarioDTO> listarTodos() {
        List<UsuarioDTO> usuariosDTO = new ArrayList<>();
        for(Usuario usuario : usuarioRepository.findAll()) {
            usuariosDTO.add(usuarioMapper.toUsuarioDTO(usuario));
        }
        return usuariosDTO;
    }

    public UsuarioDTO buscarPorId(Long id) {
        return usuarioMapper.toUsuarioDTO(usuarioRepository.findById(id).orElseThrow());
    }

    public Boolean deletar(Long id) {
        if(!usuarioRepository.existsById(id)) {return null;}
        usuarioRepository.deleteById(id);
        return !usuarioRepository.existsById(id);
    }
}

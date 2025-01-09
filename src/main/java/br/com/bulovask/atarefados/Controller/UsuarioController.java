package br.com.bulovask.atarefados.Controller;

import br.com.bulovask.atarefados.DTOs.create.UsuarioCreateDTO;
import br.com.bulovask.atarefados.DTOs.update.UsuarioUpdateDTO;
import br.com.bulovask.atarefados.ResponseObject.DefaultResObj;
import br.com.bulovask.atarefados.Service.UsuarioService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.NoSuchElementException;


@RestController
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuario/listar")
    public ResponseEntity<DefaultResObj> listarTodos() {
        return new ResponseEntity<>(
                new DefaultResObj(false, "Sucesso!", usuarioService.listarTodos()),
                HttpStatus.OK
        );
    }

    @PostMapping("/usuario/salvar")
    public ResponseEntity<DefaultResObj> salvar(@Valid @RequestBody UsuarioCreateDTO usuario) {
        try {
            return new ResponseEntity<>(
                    new DefaultResObj(false, "Salvo com sucesso!", usuarioService.salvar(usuario)),
                    HttpStatus.OK
            );
        } catch (DataIntegrityViolationException e) {
            String messageError = e.getRootCause().getMessage();
            String message = "Não foi possível salvar o usuário!";

            if(messageError.contains("Duplicate entry")) {message = "Esse e-mail já está sendo usado!";}
//            else if() {}

            return new ResponseEntity<>(
                    new DefaultResObj(true, message, null),
                    HttpStatus.BAD_REQUEST
            );
        }
    }

    @GetMapping("/usuario/listar/{id}")
    public ResponseEntity<DefaultResObj> buscarPorId(@PathVariable Long id){
        try {
            return new ResponseEntity<>(
                    new DefaultResObj(false, "Encontrado com sucesso!", usuarioService.buscarPorId(id)),
                    HttpStatus.OK
            );
        } catch (RuntimeException e) {
            return new ResponseEntity<>(
                    new DefaultResObj(true, "Usuário não encontrado!", null),
                    HttpStatus.NOT_FOUND
            );
        }
    }

    @DeleteMapping("/usuario/apagar/{id}")
    public ResponseEntity<DefaultResObj> deletar(@PathVariable Long id){
        @AllArgsConstructor
        class Res {
            boolean error;
            String message;
            HttpStatus httpStatus;
        }
        try {
            Boolean del = usuarioService.deletar(id);
            Res res = del == null ?
                    new Res(true, "Impossível apagar quem não existe!", HttpStatus.NOT_FOUND) :
                    del ?
                            new Res(false, "Usuário apagado com sucesso!", HttpStatus.OK) :
                            new Res(true, "Falha ao apagar usuário!", HttpStatus.UNAUTHORIZED);


            return new ResponseEntity<>(
                    new DefaultResObj(res.error, res.message, null),
                    res.httpStatus
            );
        } catch (DataIntegrityViolationException e) {
            String messageError = e.getRootCause().getMessage();
            String message = "Não foi possível apagar o usuário!";

            if(messageError.contains("a foreign key constraint")) {message = "Este usuário está associado a outras entidades";}
//            else if() {}

            return new ResponseEntity<>(
                    new DefaultResObj(true, message, null),
                    HttpStatus.BAD_REQUEST
            );
        } catch (RuntimeException e) {
            String messageError = e.getMessage();
            return new ResponseEntity<>(
                    new DefaultResObj(true, messageError, null),
                    HttpStatus.BAD_REQUEST
            );
        }
    }

    @PutMapping("/usuario/atualizar/{id}")
    public ResponseEntity<DefaultResObj> atualizar(@PathVariable Long id,@Valid @RequestBody UsuarioUpdateDTO usuario){
        try {
            return new ResponseEntity<>(
                    new DefaultResObj(false, "Atualizado com sucesso!", usuarioService.atualizar(id, usuario)),
                    HttpStatus.OK
            );
        } catch (NoSuchElementException e) {
            String messageError = e.getMessage();
            String message = "Não foi possível atualizar o usuário!";

            if(messageError.contains("No value present")) {message = "Impossível atualizar quem não existe!";}

            return new ResponseEntity<>(
                    new DefaultResObj(true, message, null),
                    HttpStatus.BAD_REQUEST
            );
        } catch (RuntimeException e) {
            return new ResponseEntity<>(
                    new DefaultResObj(true, e.getMessage(), null),
                    HttpStatus.UNAUTHORIZED
            );
        }
    }
}




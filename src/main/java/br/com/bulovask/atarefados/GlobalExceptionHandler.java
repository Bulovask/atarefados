package br.com.bulovask.atarefados;

import br.com.bulovask.atarefados.ResponseObject.DefaultResObj;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<DefaultResObj> handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();

        String errorMessage = bindingResult.getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.joining(", "));

        DefaultResObj errorResponse = new DefaultResObj(
                true, errorMessage, null
        );

        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<DefaultResObj> handleHttpMessageNotReadable(HttpMessageNotReadableException e) {
        DefaultResObj errorResponse = new DefaultResObj(
          true,
          "Erro ao realizar essa operação!",
          null
        );

        return ResponseEntity.badRequest().body(errorResponse);
    }
}

package net.vieracode.football.controller.advice;

import net.vieracode.football.dto.APIResponse;
import net.vieracode.football.dto.ErrorDTO;
import net.vieracode.football.exception.ClubNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ClubAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public APIResponse<?> handleMethodArgumentException(MethodArgumentNotValidException exception) {
        APIResponse<?> serviceResponse = new APIResponse<>();
        List<ErrorDTO> errors = new ArrayList<>();
        exception.getBindingResult().getFieldErrors()
                .forEach(error -> {
                    ErrorDTO errorDTO = new ErrorDTO(error.getField(), error.getDefaultMessage());
                    errors.add(errorDTO);
                });
        serviceResponse.setStatus("FAILED");
        serviceResponse.setErrors(errors);
        return serviceResponse;
    }

    @ExceptionHandler(ClubNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String clubNotFoundHandler(ClubNotFoundException ex) {
        return ex.getMessage();
    }
}

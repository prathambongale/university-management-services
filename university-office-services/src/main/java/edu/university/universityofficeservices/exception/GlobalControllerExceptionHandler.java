package edu.university.universityofficeservices.exception;

import edu.university.universityofficeservices.dataobjects.responses.ErrorMessages;
import edu.university.universityofficeservices.util.OfficeResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintDefinitionException;
import java.util.ArrayList;

@ControllerAdvice
public class GlobalControllerExceptionHandler extends OfficeResponses {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity handleValidationExceptions(MethodArgumentNotValidException ex) {

        var errors = new ErrorMessages();
        var errorMessages = new ArrayList<ErrorMessages>();

        ex.getBindingResult().getAllErrors().forEach(error -> {
            errors.setFieldName(((FieldError) error).getField());
            errors.setErrorDescription(error.getDefaultMessage());
            errors.setErrorType("MethodArgumentNotValidException");
            errorMessages.add(errors);
        });

        return buildValidationErrorResponse(errorMessages);
    }
}

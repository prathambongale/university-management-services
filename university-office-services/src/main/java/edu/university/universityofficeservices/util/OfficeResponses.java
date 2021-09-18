package edu.university.universityofficeservices.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.university.universityofficeservices.dataobjects.responses.ErrorMessages;
import edu.university.universityofficeservices.dataobjects.responses.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

public abstract class OfficeResponses {

    protected <T> ResponseEntity<ResponseMessage> buildSuccessCreateResponse(T data) {
        ResponseMessage responseMessage = new ResponseMessage();
        ArrayList<ErrorMessages> errorMessages = new ArrayList<>();
        responseMessage.setData(data);
        responseMessage.setErrorList(errorMessages);
        return new ResponseEntity<>(responseMessage, HttpStatus.CREATED);
    }

    protected ResponseEntity buildValidationErrorResponse(List<ErrorMessages> errorMessages) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setData(new ObjectMapper().createObjectNode());
        responseMessage.setErrorList(errorMessages);
        return new ResponseEntity<>(responseMessage, HttpStatus.BAD_REQUEST);
    }

    protected ResponseEntity buildExceptionResponse(Exception ex) {

        var errors = new ErrorMessages();
        var errorMessages = new ArrayList<ErrorMessages>();
        ResponseMessage responseMessage = new ResponseMessage();

        errors.setFieldName("");
        errors.setErrorDescription(ex.getMessage());
        errors.setErrorType(ex.getCause().getMessage());
        errorMessages.add(errors);

        responseMessage.setData(new ObjectMapper().createObjectNode());
        responseMessage.setErrorList(errorMessages);
        return new ResponseEntity<>(responseMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

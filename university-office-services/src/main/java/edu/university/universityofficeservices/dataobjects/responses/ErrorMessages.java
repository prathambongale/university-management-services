package edu.university.universityofficeservices.dataobjects.responses;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class ErrorMessages {

    private String fieldName;
    private String errorType;
    private String errorDescription;
}

package edu.university.universityofficeservices.dataobjects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
public class GetUserIdRequestDTO implements Serializable {

    @Email(message = "Enter valid email address")
    private String email;

    @Size(min = 10, max = 16, message = "Length of cell number should be between 10 and 16")
    private String cell;
}

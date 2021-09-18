package edu.university.universityofficeservices.dataobjects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import edu.university.universityofficeservices.validations.annotation.FieldsValueMatch;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
/*@FieldsValueMatch(
        field = "password",
        fieldMatch = "verifyPassword",
        message = "Passwords do not match!"
)*/
public class CreateUserRequestDTO implements Serializable {

    @Size(min = 3, max = 20, message = "Length of username should be between 3 and 20")
    @NotNull(message = "Username can't be null or blank")
    private String username;

    @Size(min = 8, max = 50, message = "Length of password should be between 8 and 50")
    @NotNull(message = "Password can't be null or blank")
    private String password;

    @Size(min = 8, max = 50, message = "Length of reEnterPassword should be between 8 and 50")
    @NotNull(message = "reEnterPassword can't be null or blank")
    private String verifyPassword;

    @Email(message = "Enter valid email address")
    @NotNull(message = "Email can't be null or blank")
    private String email;

    @Size(min = 10, max = 16, message = "Length of cell number should be between 10 and 16")
    @NotNull(message = "Cell number can't be null or blank")
    private String cell;
}

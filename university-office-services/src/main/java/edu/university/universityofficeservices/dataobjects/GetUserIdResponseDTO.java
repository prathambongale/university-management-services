package edu.university.universityofficeservices.dataobjects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
public class GetUserIdResponseDTO implements Serializable {

    private String userId;
}

package edu.university.universityofficeservices.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="university_office_login")
public class OfficeLogin {
    
    @Id
    @Column(name="user_id")
    private String userId;

    @Column(name="password")
    private String password;

    @Column(name="username")
    private String username;

    @Column(name="email")
    private String email;

    @Column(name="cell")
    private String cell;
}

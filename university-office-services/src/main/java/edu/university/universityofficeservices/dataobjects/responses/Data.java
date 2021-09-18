package edu.university.universityofficeservices.dataobjects.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class Data<T> implements Serializable {

    private T type;

    public Data(T type) {this.type = type;}
}

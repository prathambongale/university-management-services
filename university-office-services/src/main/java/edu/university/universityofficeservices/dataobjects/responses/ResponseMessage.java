package edu.university.universityofficeservices.dataobjects.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMessage<T> implements Serializable {

    private Data<T> data;
    private List<ErrorMessages> errorList;

    public T getData() { return this.data.getType(); }

    public void setData(T type) {
        this.data = new Data<>(type);
    }
}

package springbootspringdatacrud.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FilmsResponse implements Serializable{
    private static final int serialVersionUID = 802200815;
    @JsonProperty
    private Set<FilmResponse> filmSet;
}

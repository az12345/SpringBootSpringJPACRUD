package springbootspringdatacrud.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import springbootspringdatacrud.domain.Film;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActorResponse implements Serializable{
    private static final int serialVersionUID = 111;
    @JsonProperty
    private int actor_id;
    @JsonProperty
    private String first_name;
    @JsonProperty
    private String last_name;
    @JsonProperty
    private Set<FilmResponse> filmSet;
}

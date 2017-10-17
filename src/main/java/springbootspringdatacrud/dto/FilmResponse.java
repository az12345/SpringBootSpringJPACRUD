package springbootspringdatacrud.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import springbootspringdatacrud.domain.Actor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class FilmResponse implements Serializable {
    private static final int serialVersionUID = 11;

    @JsonProperty
    private int film_id;
    @JsonProperty
    private String title;
    @JsonProperty
    private String description;
    @JsonProperty
    private int length;
    @JsonProperty
    private String special_features;
    @JsonProperty
    private List<ActorResponse> actorSet;
}

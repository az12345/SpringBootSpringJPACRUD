package springbootspringdatacrud.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;

@Data
@JsonTypeName(value = "film")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
public class FilmDTO {
    private static final int serialVersionUID = 5745811;
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
}

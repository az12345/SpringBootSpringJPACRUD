package springbootspringdatacrud.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@JsonTypeName(value = "actor")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
public class ActorDTO implements Serializable {

    private static final int serialVersionUID = 630343885;

    @JsonProperty
    private int actor_id;
    @JsonProperty
    private String first_name;
    @JsonProperty
    private String last_name;

}
package springbootspringdatacrud.mapping;

import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.TypeMappingOptions;
import springbootspringdatacrud.domain.Actor;
import springbootspringdatacrud.domain.Film;
import springbootspringdatacrud.dto.ActorResponse;
import springbootspringdatacrud.dto.ActorsResponse;
import springbootspringdatacrud.dto.FilmResponse;


import java.util.List;
import java.util.Set;

import static org.dozer.loader.api.FieldsMappingOptions.hintA;
import static org.dozer.loader.api.FieldsMappingOptions.hintB;


public class Actor2ActorResponse  extends BeanMappingBuilder {
    @Override
    protected void configure() {
        mapping(Set.class, ActorsResponse.class, TypeMappingOptions.oneWay())
                .fields(this_(),"actorSet",
                        hintA(Actor.class),
                        hintB(ActorResponse.class));
    }
}

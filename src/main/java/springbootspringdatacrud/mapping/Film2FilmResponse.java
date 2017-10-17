package springbootspringdatacrud.mapping;

import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.TypeMappingOptions;
import springbootspringdatacrud.domain.Film;
import springbootspringdatacrud.dto.FilmResponse;
import springbootspringdatacrud.dto.FilmsResponse;

import java.util.List;
import java.util.Set;

import static org.dozer.loader.api.FieldsMappingOptions.hintA;
import static org.dozer.loader.api.FieldsMappingOptions.hintB;


public class Film2FilmResponse extends BeanMappingBuilder {
    @Override
    protected void configure() {
        mapping(Set.class, FilmsResponse.class, TypeMappingOptions.oneWay())
                .fields(this_(),"filmSet",
                        hintA(Film.class),
                        hintB(FilmResponse.class));

    }
}

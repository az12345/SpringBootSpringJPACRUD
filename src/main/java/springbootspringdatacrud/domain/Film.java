package springbootspringdatacrud.domain;

import lombok.*;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(name = "film")
public class Film implements Persistable<Integer>{
    private static final int seialVesionUID = 10051;

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer film_id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private int length;

    @Column
    private String special_features;

    @ManyToMany(mappedBy = "filmSet")
    private List<Actor> actorSet;

    @Override
    public Integer getId() {
        return film_id;
    }

    @Override
    public boolean isNew() {
        return Objects.nonNull(film_id);
    }
}

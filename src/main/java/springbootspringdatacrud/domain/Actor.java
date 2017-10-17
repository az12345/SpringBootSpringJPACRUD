package springbootspringdatacrud.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(name="actor")
public class Actor implements Persistable<Integer> {

    private static final int seialVesionUID = 1001;

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "actorfilm",
            joinColumns = {@JoinColumn(name="actor_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "film_id", referencedColumnName = "film_id")})
    private Set<Film> filmSet;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return Objects.nonNull(id);
    }
}

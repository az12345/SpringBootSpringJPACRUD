package springbootspringdatacrud.domain;

import lombok.*;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@ToString
@Table(name="actor")
public class Actor implements Persistable<Integer> {
    private static final int seialVesionUID = 1001;
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int actor_id;
    @Column
    private String first_name;
    @Column
    private String last_name;
    @ManyToMany
    @JoinTable(name = "actorfilm",
            joinColumns = {@JoinColumn(name="actor_id")},
            inverseJoinColumns = {@JoinColumn(name = "film_id")})
    private Set<Film> filmSet;

    @Override
    public Integer getId() {
        return actor_id;
    }

    @Override
    public boolean isNew() {
        return Objects.nonNull(actor_id);
    }
}

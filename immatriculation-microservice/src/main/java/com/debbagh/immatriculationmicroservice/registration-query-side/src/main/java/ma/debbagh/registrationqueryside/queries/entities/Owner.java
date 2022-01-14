package ma.debbagh.exam.registration.queries.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Owner {
    @Id
    private String id;
    private String nom;
    private Date birthday;
    private String email;
    @OneToMany(mappedBy = "owner")
    private Collection<Vehicle> vehicles;
}

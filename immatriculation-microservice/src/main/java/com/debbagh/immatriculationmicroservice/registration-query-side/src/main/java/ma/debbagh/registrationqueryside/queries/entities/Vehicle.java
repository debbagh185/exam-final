package ma.debbagh.exam.registration.queries.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Vehicle {
    @Id
    private String id;
    private String name;
    private String registrationNumber;
    @ManyToOne
    private Owner owner;
}

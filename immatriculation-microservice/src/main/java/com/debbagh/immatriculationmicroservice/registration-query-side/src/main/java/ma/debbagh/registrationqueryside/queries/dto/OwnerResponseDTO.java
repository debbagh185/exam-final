package ma.debbagh.exam.registration.queries.dto;

import ma.debbagh.exam.registration.enums.OperationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.debbagh.exam.registration.queries.entities.Vehicle;

import java.util.Collection;
import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
public class OwnerResponseDTO {
    private String id;
    private String nom;
    private Date birthday;
    private String email;
    private Collection<Vehicle> vehicles;
}

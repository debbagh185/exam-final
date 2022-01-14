package ma.debbagh.exam.registration.queries.dto;

import ma.debbagh.exam.registration.enums.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.debbagh.exam.registration.queries.entities.Owner;

@Data @AllArgsConstructor @NoArgsConstructor
public class VehicleResponseDTO {
    private String id;
    private String name;
    private String registrationNumber;
    private Owner owner;
}

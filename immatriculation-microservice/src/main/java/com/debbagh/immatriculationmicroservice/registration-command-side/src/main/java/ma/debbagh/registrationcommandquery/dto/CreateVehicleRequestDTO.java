package ma.debbagh.exam.registration.commands.dto;

import lombok.Data;
import ma.debbagh.exam.registration.queries.entities.Owner;

@Data
public class CreateVehicleRequestDTO {
    private String name;
    private String registrationNumber;
    private Owner owner;
}

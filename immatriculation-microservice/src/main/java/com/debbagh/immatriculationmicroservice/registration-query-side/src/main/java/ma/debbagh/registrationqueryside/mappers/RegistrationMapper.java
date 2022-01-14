package ma.debbagh.exam.registration.mappers;

import ma.debbagh.exam.registration.queries.dto.OwnerResponseDTO;
import ma.debbagh.exam.registration.queries.dto.VehicleResponseDTO;
import ma.debbagh.exam.registration.queries.entities.Owner;
import ma.debbagh.exam.registration.queries.entities.Vehicle;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RegistrationMapper {
    VehicleResponseDTO vehicleToVehicleDTO(Vehicle vehicle);
    OwnerResponseDTO ownerToOwnerDTO(Owner owner);
}

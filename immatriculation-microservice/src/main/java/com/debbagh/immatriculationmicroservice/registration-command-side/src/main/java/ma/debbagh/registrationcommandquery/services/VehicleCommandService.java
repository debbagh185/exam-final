package ma.debbagh.exam.registration.commands.services;

import ma.debbagh.exam.registration.commands.dto.CreateVehicleRequestDTO;

import java.util.concurrent.CompletableFuture;

public interface VehicleCommandService {
    CompletableFuture<String> createVehicle(CreateVehicleRequestDTO vehicleRequestDTO);
}

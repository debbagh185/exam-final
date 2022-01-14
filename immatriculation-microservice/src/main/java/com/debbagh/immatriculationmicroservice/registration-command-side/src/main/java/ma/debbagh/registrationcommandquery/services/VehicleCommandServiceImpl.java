package ma.debbagh.exam.registration.commands.services;

import ma.debbagh.exam.registration.commands.dto.CreateVehicleRequestDTO;
import ma.debbagh.exam.registration.commands.commands.CreateAccountCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
@Service
public class VehicleCommandServiceImpl implements VehicleCommandService {
    @Autowired
    private CommandGateway commandGateway;
    @Override
    public CompletableFuture<String> createVehicle(CreateVehicleRequestDTO vehicleRequestDTO) {
        return commandGateway.send(new CreateAccountCommand(UUID.randomUUID().toString(), vehicleRequestDTO.getName(), vehicleRequestDTO.getRegistrationNumber(), vehicleRequestDTO.getOwner()));
    }
}

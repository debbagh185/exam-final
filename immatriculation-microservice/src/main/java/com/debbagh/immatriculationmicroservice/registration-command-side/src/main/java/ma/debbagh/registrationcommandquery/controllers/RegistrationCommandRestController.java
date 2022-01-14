package ma.debbagh.exam.registration.commands.controllers;

import ma.debbagh.exam.registration.commands.dto.CreateVehicleRequestDTO;
import ma.debbagh.exam.registration.commands.services.VehicleCommandService;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(path="/commands")
public class RegistrationCommandRestController {

    private final VehicleCommandService accountCommandService;

    public RegistrationCommandRestController(VehicleCommandService accountCommandService) {
        this.accountCommandService = accountCommandService;
    }

    @PostMapping(path = "/vehicles/create")
    public CompletableFuture<String> createAccount(@RequestBody CreateVehicleRequestDTO vehicleRequestDTO){
       return accountCommandService.createVehicle(vehicleRequestDTO);
    }

}

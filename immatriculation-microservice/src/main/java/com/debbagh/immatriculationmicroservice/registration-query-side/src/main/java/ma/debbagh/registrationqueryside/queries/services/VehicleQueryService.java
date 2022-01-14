package ma.debbagh.exam.registration.queries.services;

import ma.debbagh.exam.registration.enums.OperationType;
import ma.debbagh.exam.registration.mappers.RegistrationMapper;
import ma.debbagh.exam.registration.queries.dto.*;
import ma.debbagh.exam.registration.queries.entities.Vehicle;
import ma.debbagh.exam.registration.queries.repository.VehicleRepository;
import ma.debbagh.exam.registration.events.VehicleCreatedEvent;
import ma.debbagh.exam.registration.queries.repository.OwnerRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleQueryService {
    private final VehicleRepository vehicleRepository;
    private final OwnerRepository ownerRepository;
    private final RegistrationMapper registrationMapper;
    private final QueryUpdateEmitter queryUpdateEmitter;

    public VehicleQueryService(VehicleRepository vehicleRepository, OwnerRepository ownerRepository, RegistrationMapper registrationMapper, QueryUpdateEmitter queryUpdateEmitter) {
        this.vehicleRepository = vehicleRepository;
        this.ownerRepository = ownerRepository;
        this.registrationMapper = registrationMapper;
        this.queryUpdateEmitter = queryUpdateEmitter;
    }

    @EventHandler
    @Transactional
    public void on(VehicleCreatedEvent vehicleCreatedEvent){
        Vehicle vehicle=new Vehicle();
        vehicle.setId(vehicleCreatedEvent.getId());
        vehicle.setName(vehicleCreatedEvent.getName());
        vehicle.setRegistrationNumber(vehicleCreatedEvent.getRegistrationNumber());
        vehicle.setOwner(vehicleCreatedEvent.getOwner());
        vehicleRepository.save(vehicle);
    }

    @QueryHandler
    public VehicleResponseDTO on(GetVehicleQueryDTO vehicleQueryDTO) {
        Vehicle vehicle = vehicleRepository.findById(vehicleQueryDTO.getId()).get();
        return registrationMapper.vehicleToVehicleDTO(vehicle);
    }
    @QueryHandler
    public List<VehicleResponseDTO> on(GetAllVehiclesRequestDTO vehiclesRequestDTO) {
        List<Vehicle> vehiclesList = vehicleRepository.findAll();
        return vehiclesList.stream().map((v-> registrationMapper.vehicleToVehicleDTO(v))).collect(Collectors.toList());
    }
    @QueryHandler
    public List<VehicleResponseDTO> on(GetOwnerVehiclesQueryDTO ownerVehiclesQueryDTO) {
        PagedModel<Vehicle> vehicleList = vehicleRepository.findAllByOwnerId(ownerVehiclesQueryDTO.getOwnerId());
        return vehicleList.getContent().stream().map(v-> registrationMapper.vehicleToVehicleDTO(v)).collect(Collectors.toList());
    }
}

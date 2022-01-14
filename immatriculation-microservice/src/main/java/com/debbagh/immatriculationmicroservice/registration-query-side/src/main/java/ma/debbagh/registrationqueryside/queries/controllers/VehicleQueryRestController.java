package ma.debbagh.exam.registration.queries.controllers;

import ma.debbagh.exam.registration.queries.dto.*;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.SubscriptionQueryResult;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping(path = "/query")
public class VehicleQueryRestController {

    private QueryGateway queryGateway;

    public VehicleQueryRestController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping(path = "/vehicles/{id}")
    public VehicleResponseDTO getVehicle(@PathVariable String id){
        GetVehicleQueryDTO queryDTO=new GetVehicleQueryDTO();
        queryDTO.setId(id);
        return queryGateway.query(queryDTO, VehicleResponseDTO.class).join();
    }

    @GetMapping(path = "/vehicles")
    public List<VehicleResponseDTO> getAll(){
        return queryGateway.query(new GetAllVehiclesRequestDTO(),
                ResponseTypes.multipleInstancesOf(VehicleResponseDTO.class)).join();
    }

    @GetMapping(path = "/vehiclesByOwner/{ownerId}")
    public List<OwnerResponseDTO> accountOperationList(@PathVariable String accountId){
        return queryGateway.query(new GetOwnerVehiclesQueryDTO(accountId),ResponseTypes.multipleInstancesOf(OwnerResponseDTO.class)).join();
    }

    @GetMapping(value = "/{vehicleId}/watch",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<VehicleResponseDTO> watch(@PathVariable String vehicleId){

        SubscriptionQueryResult<VehicleResponseDTO, VehicleResponseDTO> result=
                queryGateway.subscriptionQuery(
                        new GetVehicleQueryDTO(vehicleId),
                        ResponseTypes.instanceOf(VehicleResponseDTO.class),
                        ResponseTypes.instanceOf(VehicleResponseDTO.class)
                        );
        return result.initialResult().concatWith(result.updates());
    }

}

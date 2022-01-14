package ma.debbagh.exam.registration.queries.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class GetOwnerVehiclesQueryDTO {
    private String ownerId;
}

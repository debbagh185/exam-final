package ma.debbagh.exam.registration.queries.repository;

import ma.debbagh.exam.registration.queries.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.hateoas.PagedModel;

public interface VehicleRepository extends JpaRepository<Vehicle,String> {
    PagedModel<Vehicle> findAllByOwnerId(String ownerId);
}

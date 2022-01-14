package ma.debbagh.exam.registration.queries.repository;

import ma.debbagh.exam.registration.queries.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner,String> {
}

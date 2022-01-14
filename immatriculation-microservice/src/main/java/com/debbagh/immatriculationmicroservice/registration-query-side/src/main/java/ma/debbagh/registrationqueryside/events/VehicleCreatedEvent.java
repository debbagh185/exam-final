package ma.debbagh.exam.registration.events;

import lombok.Getter;
import ma.debbagh.exam.registration.queries.entities.Owner;

public class VehicleCreatedEvent extends BaseEvent<String> {
    @Getter private final String name;
    @Getter private final String registrationNumber;
    @Getter private final Owner owner;

    public VehicleCreatedEvent(String id, String name, String registrationNumber, Owner owner) {
        super(id);
        this.name = name;
        this.registrationNumber = registrationNumber;
        this.owner = owner;
    }
}

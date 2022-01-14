package ma.debbagh.exam.registration.commands.commands;

import lombok.Getter;
import ma.debbagh.exam.registration.queries.entities.Owner;

public class CreateAccountCommand extends BaseCommand<String> {
    @Getter private String name;
    @Getter private String registrationNumber;
    @Getter private Owner owner;

    public CreateAccountCommand(String id, String name, String registrationNumber, Owner owner) {
        super(id);
        this.name = name;
        this.registrationNumber = registrationNumber;
        this.owner = owner;
    }
}

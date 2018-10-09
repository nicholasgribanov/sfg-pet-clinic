package name.nicholasgribanov.sfgpetclinic.repositories;

import name.nicholasgribanov.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}

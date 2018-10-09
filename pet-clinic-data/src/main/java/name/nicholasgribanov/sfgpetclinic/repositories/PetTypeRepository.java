package name.nicholasgribanov.sfgpetclinic.repositories;

import name.nicholasgribanov.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

interface PetTypeRepository extends CrudRepository<PetType,Long> {
}

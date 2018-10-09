package name.nicholasgribanov.sfgpetclinic.repositories;

import name.nicholasgribanov.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}

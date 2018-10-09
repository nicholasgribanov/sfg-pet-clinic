package name.nicholasgribanov.sfgpetclinic.repositories;

import name.nicholasgribanov.sfgpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}

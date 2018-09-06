package name.nicholasgribanov.sfgpetclinic.services;

import name.nicholasgribanov.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}

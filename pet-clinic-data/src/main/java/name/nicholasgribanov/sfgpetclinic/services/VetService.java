package name.nicholasgribanov.sfgpetclinic.services;

import name.nicholasgribanov.sfgpetclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Long id);
    Vet save(Vet pet);
    Set<Vet> findAll();
}

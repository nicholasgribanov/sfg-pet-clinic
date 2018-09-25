package name.nicholasgribanov.sfgpetclinic.bootstrap;

import name.nicholasgribanov.sfgpetclinic.model.Owner;
import name.nicholasgribanov.sfgpetclinic.model.PetType;
import name.nicholasgribanov.sfgpetclinic.model.Vet;
import name.nicholasgribanov.sfgpetclinic.services.OwnerService;
import name.nicholasgribanov.sfgpetclinic.services.PetTypeService;
import name.nicholasgribanov.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);


        Owner owner1 = new Owner();
        owner1.setFirstName("Kostia");
        owner1.setLastName("Vaschenko");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Roman");
        owner2.setLastName("Varlamov");
        ownerService.save(owner2);

        System.out.println("Loaded owners ...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Misha");
        vet1.setLastName("Chilli");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Lesha");
        vet2.setLastName("Kot");
        vetService.save(vet2);

        System.out.println("Loaded vets ...");


    }
}

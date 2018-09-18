package name.nicholasgribanov.sfgpetclinic.bootstrap;

import name.nicholasgribanov.sfgpetclinic.model.Owner;
import name.nicholasgribanov.sfgpetclinic.model.Vet;
import name.nicholasgribanov.sfgpetclinic.services.OwnerService;
import name.nicholasgribanov.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Kostia");
        owner1.setLastName("Vaschenko");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Roman");
        owner2.setLastName("Varlamov");
        ownerService.save(owner2);

        System.out.println("Loaded owners ...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Misha");
        vet1.setLastName("Chilli");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Lesha");
        vet2.setLastName("Kot");
        vetService.save(vet2);

        System.out.println("Loaded vets ...");


    }
}

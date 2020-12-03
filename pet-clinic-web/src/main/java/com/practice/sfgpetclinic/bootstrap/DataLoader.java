package com.practice.sfgpetclinic.bootstrap;

import com.practice.sfgpetclinic.model.Owner;
import com.practice.sfgpetclinic.model.Vet;
import com.practice.sfgpetclinic.service.OwnerService;
import com.practice.sfgpetclinic.service.VetService;
import com.practice.sfgpetclinic.service.map.OwnerMapService;
import com.practice.sfgpetclinic.service.map.VetMapService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        this.ownerService = new OwnerMapService();
        this.vetService = new VetMapService();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Varun");
        owner1.setLastName("Agarwal");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Shivika");
        owner2.setLastName("Bansal");
        ownerService.save(owner2);

        System.out.println("Owners Loaded");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Deepak");
        vet1.setLastName("Agarwal");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Sarika");
        vet2.setLastName("Agarwal");
        vetService.save(vet2);

        System.out.println("Vets Loaded");

    }
}

package com.practice.sfgpetclinic.bootstrap;

import com.practice.sfgpetclinic.model.Owner;
import com.practice.sfgpetclinic.model.Pet;
import com.practice.sfgpetclinic.model.PetType;
import com.practice.sfgpetclinic.model.Vet;
import com.practice.sfgpetclinic.service.OwnerService;
import com.practice.sfgpetclinic.service.PetTypeService;
import com.practice.sfgpetclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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
        dog.setName("dog");
        PetType savedDog=petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCat=petTypeService.save(cat);

        System.out.println("PetType Loaded");

        Owner owner1 = new Owner();
        owner1.setFirstName("Varun");
        owner1.setLastName("Agarwal");
        owner1.setAddress("225E, Saket");
        owner1.setCity("Meerut");
        owner1.setTelephone("7530003385");

        Pet varunPet = new Pet();
        varunPet.setPetType(savedCat);
        varunPet.setOwner(owner1);
        varunPet.setName("Pussy");
        varunPet.setBirthDate(LocalDate.now());
        owner1.getPets().add(varunPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Shivika");
        owner2.setLastName("Bansal");
        owner2.setAddress("Sanjay Medicos");
        owner2.setCity("Dehradun");
        owner2.setTelephone("7518893250");

        Pet shivikaPet = new Pet();
        shivikaPet.setPetType(savedDog);
        shivikaPet.setOwner(owner2);
        shivikaPet.setName("Kiwi");
        shivikaPet.setBirthDate(LocalDate.now());
        owner1.getPets().add(shivikaPet);
        ownerService.save(owner2);

        System.out.println("Owners Loaded");

        Vet vet1 = new Vet();
        vet1.setFirstName("Deepak");
        vet1.setLastName("Agarwal");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Sarika");
        vet2.setLastName("Agarwal");
        vetService.save(vet2);

        System.out.println("Vets Loaded");

    }
}

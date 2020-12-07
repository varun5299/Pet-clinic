package com.practice.sfgpetclinic.bootstrap;

import com.practice.sfgpetclinic.model.*;
import com.practice.sfgpetclinic.service.OwnerService;
import com.practice.sfgpetclinic.service.PetTypeService;
import com.practice.sfgpetclinic.service.SpecialityService;
import com.practice.sfgpetclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }


    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if(count ==0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDog=petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCat=petTypeService.save(cat);

        System.out.println("PetType Loaded");

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality dentistry = new Speciality();
        radiology.setDescription("Dentistry");
        Speciality surgery = new Speciality();
        radiology.setDescription("Surgery");

        Speciality savedRadiology = specialityService.save(radiology);
        Speciality savedDentistry = specialityService.save(dentistry);
        Speciality savedSurgery = specialityService.save(surgery);

        System.out.println("Speciality Loaded");

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
        vet1.getSpecialities().add(savedDentistry);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Sarika");
        vet2.setLastName("Agarwal");
        vet2.getSpecialities().add(savedRadiology);
        vetService.save(vet2);

        System.out.println("Vets Loaded");
    }
}

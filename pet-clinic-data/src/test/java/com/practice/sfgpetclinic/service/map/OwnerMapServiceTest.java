package com.practice.sfgpetclinic.service.map;

import com.practice.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetMapService(), new PetTypeMapService());
        Owner owner = new Owner();
        owner.setId(1L);
        owner.setLastName("Agarwal");
        ownerMapService.save(owner);
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerMapService.findAll();
        assertEquals(1,owners.size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(1L);
        assertEquals(0,ownerMapService.findAll().size());
    }

    @Test
    void delete() {
        Owner owner = ownerMapService.findById(1L);
        ownerMapService.delete(owner);
        assertEquals(0,ownerMapService.findAll().size());
    }

    @Test
    void saveExisitngId() {
        Owner owner = new Owner();
        owner.setId(2L);
        ownerMapService.save(owner);
        assertEquals(2L,ownerMapService.findById(2L).getId());
    }

    @Test
    void saveNoId() {
        Owner owner = new Owner();
        Owner savedOwner=ownerMapService.save(owner);
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(1L);
        assertEquals("Agarwal",owner.getLastName());
    }

    @Test
    void findByLastName() {
        Owner owner = ownerMapService.findByLastName("Agarwal");
        assertNotNull(owner);
        assertEquals(1L,owner.getId());
    }
}
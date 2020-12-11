package com.practice.sfgpetclinic.service.springdatajpa;

import com.practice.sfgpetclinic.model.Owner;
import com.practice.sfgpetclinic.repository.OwnerRepository;
import com.practice.sfgpetclinic.repository.PetRepository;
import com.practice.sfgpetclinic.repository.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJPAServiceTest {

    private final Long mockId=1L;
    private final String mockLastName="Agarwal";
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;
    @InjectMocks
    OwnerSDJPAService ownerSDJPAService;
    Owner owner;

    @BeforeEach
    void setUp() {
        owner = new Owner();
        owner.setId(mockId);
        owner.setLastName(mockLastName);
        //ownerSDJPAService.save(owner);
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(owner);

        Owner owner1 = ownerSDJPAService.findByLastName(mockLastName);

        assertEquals(mockLastName, owner1.getLastName());

        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> returnOwnersSet = new HashSet<>();

        Owner owner1 = new Owner();
        owner1.setId(1L);
        Owner owner2 = new Owner();
        owner2.setId(2L);

        returnOwnersSet.add(owner1);
        returnOwnersSet.add(owner2);

        when(ownerRepository.findAll()).thenReturn(returnOwnersSet);

        Set<Owner> owners = ownerSDJPAService.findAll();

        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(owner));

        Owner owner = ownerSDJPAService.findById(1L);

        assertNotNull(owner);
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner owner = ownerSDJPAService.findById(1L);

        assertNull(owner);
    }

    @Test
    void save() {

        Owner owner1 = new Owner();
        owner1.setId(1L);

        when(ownerRepository.save(any())).thenReturn(owner);

        Owner savedOwner = ownerSDJPAService.save(owner1);

        assertNotNull(savedOwner);

        verify(ownerRepository).save(any());

    }

    @Test
    void delete() {
        ownerSDJPAService.delete(owner);

        //default is 1 times
        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        ownerSDJPAService.deleteById(1L);

        verify(ownerRepository).deleteById(anyLong());
    }
}
package com.practice.sfgpetclinic.controllers;

import com.practice.sfgpetclinic.model.Owner;
import com.practice.sfgpetclinic.service.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnersControllerTest {

    @Mock
    OwnerService ownerService;
    @InjectMocks
    OwnersController ownersController;

    Set<Owner> ownerSet;
    MockMvc mockMvc;


    @BeforeEach
    void setUp() {
        ownerSet = new HashSet<>();

        Owner owner1 = new Owner();
        Owner owner2 = new Owner();

        owner1.setId(1L);
        owner2.setId(2L);

        ownerSet.add(owner1);
        ownerSet.add(owner2);

        mockMvc = MockMvcBuilders.standaloneSetup(ownersController).build();

    }

    @Test
    void listOwners() throws Exception{
        when(ownerService.findAll()).thenReturn(ownerSet);

        mockMvc.perform(get("/owners"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("listOfOwners", hasSize(2)));
    }

    @Test
    void listOwnersByIndex() throws Exception {
        when(ownerService.findAll()).thenReturn(ownerSet);

        mockMvc.perform(get("/owners/index"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("listOfOwners", hasSize(2)));
    }

    @Test
    void findOwners() throws Exception {
        mockMvc.perform(get("/owners/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("notImplemented"));

        verifyNoInteractions(ownerService);

    }
}
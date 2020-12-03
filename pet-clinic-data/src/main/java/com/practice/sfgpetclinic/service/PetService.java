package com.practice.sfgpetclinic.service;

import com.practice.sfgpetclinic.model.Pet;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface PetService extends CrudService<Pet, Long>{

}

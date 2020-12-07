package com.practice.sfgpetclinic.service;

import com.practice.sfgpetclinic.model.Pet;
import org.springframework.stereotype.Service;


@Service
public interface PetService extends CrudService<Pet, Long>{

}

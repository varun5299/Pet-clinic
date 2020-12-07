package com.practice.sfgpetclinic.service;

import com.practice.sfgpetclinic.model.PetType;
import org.springframework.stereotype.Service;

@Service
public interface PetTypeService extends CrudService<PetType, Long> {
}

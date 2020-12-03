package com.practice.sfgpetclinic.service;

import com.practice.sfgpetclinic.model.Owner;
import com.practice.sfgpetclinic.model.Vet;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface VetService extends CrudService<Vet, Long>{

}

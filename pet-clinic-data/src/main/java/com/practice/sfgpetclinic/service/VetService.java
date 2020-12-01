package com.practice.sfgpetclinic.service;

import com.practice.sfgpetclinic.model.Owner;
import com.practice.sfgpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}

package com.practice.sfgpetclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="vets")
public class Vet extends Person{

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="vet_speciality",
            joinColumns = @JoinColumn(name="vet_id"),
            inverseJoinColumns = @JoinColumn(name="speciality_id"))
    private Set<Speciality> specialities = new HashSet<>();

}

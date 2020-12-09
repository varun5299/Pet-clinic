package com.practice.sfgpetclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name="pet_Type")
public class PetType extends BaseEntity{

    @Column(name="name")
    private String name;

}

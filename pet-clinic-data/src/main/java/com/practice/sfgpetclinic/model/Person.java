package com.practice.sfgpetclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Setter
@Getter
@MappedSuperclass
public class Person extends BaseEntity{

    @Column(name="first_Name")
    private String firstName;

    @Column(name="last_Name")
    private String lastName;

}

package com.practice.sfgpetclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name="visit")
public class Visit extends BaseEntity{

    @Column(name="date")
    private LocalDate date;
    @Column(name="description")
    private String description;

    @ManyToOne
    @JoinColumn(name="pet_id")
    private Pet pet;

}

package com.practice.sfgpetclinic.service.map;

import com.practice.sfgpetclinic.model.Speciality;
import com.practice.sfgpetclinic.model.Vet;
import com.practice.sfgpetclinic.service.SpecialityService;
import com.practice.sfgpetclinic.service.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetMapService extends AbstractMapService<Vet,Long> implements VetService {

    private final SpecialityService specialtyService;

    public VetMapService(SpecialityService specialityService) {
        this.specialtyService = specialityService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        if (object.getSpecialities().size() > 0){
            object.getSpecialities().forEach(speciality -> {
                if(speciality.getId() == null){
                    Speciality savedSpecialty = specialtyService.save(speciality);
                    speciality.setId(savedSpecialty.getId());
                }
            });
        }

        return super.save(object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}

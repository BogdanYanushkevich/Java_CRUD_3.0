package com.bogdan_yanushkevich.javacore.crud.service.impl;

import com.bogdan_yanushkevich.javacore.crud.model.Specialty;
import com.bogdan_yanushkevich.javacore.crud.repository.SpecialtyRepository;
import com.bogdan_yanushkevich.javacore.crud.repository.hib_rep.HibSpecialtyRepositoryImpl;
import com.bogdan_yanushkevich.javacore.crud.service.SpecialtyService;

import java.util.List;

public class SpecialtyServiceImpl implements SpecialtyService {

    private final SpecialtyRepository sr;

    public SpecialtyServiceImpl() {
        this.sr = new HibSpecialtyRepositoryImpl();
    }
    public SpecialtyServiceImpl(SpecialtyRepository specialtyRepository) {
        this.sr = specialtyRepository;
    }

    public Specialty create(Specialty specialty){
        return sr.create(specialty);
    }

    @Override
    public Specialty read(Long id){
        return sr.read(id);
    }

    @Override
    public Specialty update(Specialty specialty){
        return sr.update(specialty);
    }

    @Override
    public void delete(Long id){
        sr.delete(id);
    }

    @Override
    public List<Specialty> getALl() {
        return sr.getALl();
    }


}

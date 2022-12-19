package com.bogdan_yanushkevich.javacore.crud.repository;
import com.bogdan_yanushkevich.javacore.crud.model.Specialty;

public interface SpecialtyRepository extends GenericRepository<Specialty, Long> {
    public Specialty create(Specialty specialty);
    public Specialty update(Specialty specialty);
}

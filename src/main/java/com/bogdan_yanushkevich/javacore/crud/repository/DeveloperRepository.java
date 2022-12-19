package com.bogdan_yanushkevich.javacore.crud.repository;

import com.bogdan_yanushkevich.javacore.crud.model.Developer;

public interface DeveloperRepository extends GenericRepository<Developer, Long> {
    public Developer create(Developer developer);

    public Developer update(Developer developer);
}


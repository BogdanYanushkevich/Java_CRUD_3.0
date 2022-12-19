package com.bogdan_yanushkevich.javacore.crud.service;

import com.bogdan_yanushkevich.javacore.crud.model.Developer;

public interface DeveloperService extends GenericService<Developer, Long> {
    Developer create(Developer developer);

    Developer update(Developer developer);
}

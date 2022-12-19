package com.bogdan_yanushkevich.javacore.crud.repository;

import java.util.List;

public interface GenericRepository<T, ID> {


    T read(Long ID);

    void delete(ID id);

    List<T> getALl();

}

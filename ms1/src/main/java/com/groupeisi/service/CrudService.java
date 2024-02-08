package com.groupeisi.service;

import java.util.List;

public interface CrudService<D> {
    public List<D> findAll();

    public D findById(Long id);

    public void delete(Long id);

    public D update(D dto);

    public D save(D dto);
}

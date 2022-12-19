package org.bedu.proyecto.service;

import java.util.List;
import java.util.Optional;

import org.bedu.proyecto.dto.ProductsDTO;

public interface ProductsService {
    
    List<Products> findAll();

    Optional<ProductsDTO> findById(long id);

    ProductsDTO save(ProductsDTO data);

    void update(long id, ProductsDTO data) throws Exception;

    void delete(long id) throws Exception;

}

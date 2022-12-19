package org.bedu.proyecto.service.Implementation;

public class ProductServiceImplementation {
    
}
package org.bedu.api.service.implementation;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.bedu.proyecto.dto.ProductsDTO;
import org.bedu.proyecto.entity.Products;
import org.bedu.proyecto.mapper.ProductsMapper;
import org.bedu.proyecto.repository.ProductsRepository;
import org.bedu.proyecto.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductsServiceImplementation implements ProductsService {

  private ProductsMapper mapper;
  private ProductsRepository repository;

  @Autowired
  public ProductsServiceImplementation(ProductsMapper mapper, CourseRepository repository) {
    this.mapper = mapper;
    this.repository = repository;
  }

  public List<ProductsDTO> findAll() {
    List<Products> products = repository.findAll();

    List<ProductsDTO> mappedProducts = new LinkedList<>();

    for (Products c : Products) {
      mappedProducts.add(mapper.toDTO(c));
    }

    return mappedProducts;

  }

  public Optional<ProductsDTO> findById(long id) {
    return null;
  }

  public ProductsDTO save(ProductsDTO data) {
    Products entity = mapper.toEntity(data);
    return mapper.toDTO(repository.save(entity));
  }

  public void update(long id, ProductsDTO data) throws Exception {
    Optional<Products> result = repository.findById(id);

    if (result.isEmpty()) {
      throw new Exception("Producto inexistente");
    }

    Productos productos = result.get();

    productos.setName(data.getName());

    repository.save(productos);
  }

  public void delete(long id) throws Exception {
    Optional<Products> result = repository.findById(id);

    if (result.isEmpty()) {
      throw new Exception("Producto inexistente");
    }

    repository.deleteById(id);
  }
}


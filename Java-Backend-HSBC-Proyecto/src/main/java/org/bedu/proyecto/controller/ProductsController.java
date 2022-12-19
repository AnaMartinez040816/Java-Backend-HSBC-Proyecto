package org.bedu.proyecto.controller;


import java.util.List;

import org.bedu.proyecto.dto.ProductosDTO;
import org.bedu.proyecto.service.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Productos")
public class ProductsController {
   
    private ProductsService service;

  @Autowired
  public ProductsController(ProductsService service) {
    this.service = service;
  }

  @GetMapping
  public List<ProductsDTO> findAll() {
    return service.findAll();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ProductsDTO save(@RequestBody ProductsDTO data) {
    return service.save(data);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void update(@PathVariable("id") long id, @RequestBody ProductsDTO data) throws Exception {
    service.update(id, data);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable("id") long id) throws Exception {
    service.delete(id);
  }
}

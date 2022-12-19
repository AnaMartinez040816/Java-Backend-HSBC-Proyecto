package org.bedu.proyecto.dto;

import java.util.Date;

import lombok.Data;



@Data

public class ProductsDTO {
    private long id;
    private String name;
    private Date CreatedAt;
    private Date updatedAt;
    
}

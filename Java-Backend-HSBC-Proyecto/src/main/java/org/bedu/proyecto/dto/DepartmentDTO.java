package org.bedu.proyecto.dto;

import java.util.Date;

import lombok.Data;

@Data

public class DepartmentDTO {
    private long id;
    private String name;
    private Date created_at;
    private Date updated_at;
    private CourseDTO course;
    
}

@Column(name = "created_at")
@CreationTimestamp
private Date createdAt;

@Column(name = "updated_at")
@UpdateTimestamp
private Date updatedAt;

@OneToMany
@JoinColumn(name = "product_id")
Set<Products> products;

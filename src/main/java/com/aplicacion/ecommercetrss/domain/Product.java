package com.aplicacion.ecommercetrss.domain;

import lombok.*;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "products")//mapeo de la clase con nombre products en la base de datos 

public class Product {
    
    @Id //identificador primario valor autogenerado 
    // los mapea con un tamaño por defecto ejemplo en el string lo mapea con un varchar (255)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private String category;
    @Column
    private float price;
    @Column
    private String image;

    @Column (name="creation_date")
    private LocalDateTime creationDate;

}


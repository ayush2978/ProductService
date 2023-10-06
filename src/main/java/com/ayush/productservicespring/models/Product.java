package com.ayush.productservicespring.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This class is holding entities in our system, i.e consider these classes as special classes and create corresponding tables for those.
 */

/**
 * @Entity is provided by JPA but who is making use of it...Hibernate..why because Hibernate implements the JPA specification.
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product extends BaseModel {
    private double price;
    private String title;
    // P:C
    // 1:1
    // m:1
    @ManyToOne(cascade = CascadeType.ALL)
    private Category category; // this is a relation and we have not specified the cardinality of the relation
    private String description;
    private String image;
}

package com.manejo_excepciones.excepciones_manejo.models;


import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "products")
public class Product{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @JsonProperty("item")
    String item;
    @JsonProperty("price")
    Integer price;
    @JsonProperty("available")
    Integer available;
    @JsonProperty("discount")
    Integer discount;
    @JsonProperty("category")
    String category;
    @JsonProperty("barcode")
    String barcode;



}

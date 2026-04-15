package com.manejo_excepciones.excepciones_manejo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manejo_excepciones.excepciones_manejo.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}

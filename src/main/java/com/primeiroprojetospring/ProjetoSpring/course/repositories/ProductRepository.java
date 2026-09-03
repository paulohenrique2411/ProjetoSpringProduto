package com.primeiroprojetospring.ProjetoSpring.course.repositories;

import com.primeiroprojetospring.ProjetoSpring.course.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}

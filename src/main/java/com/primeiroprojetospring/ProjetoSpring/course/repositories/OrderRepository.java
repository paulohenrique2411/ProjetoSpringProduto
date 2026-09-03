package com.primeiroprojetospring.ProjetoSpring.course.repositories;

import com.primeiroprojetospring.ProjetoSpring.course.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {

}

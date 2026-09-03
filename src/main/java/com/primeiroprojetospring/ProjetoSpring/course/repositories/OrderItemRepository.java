package com.primeiroprojetospring.ProjetoSpring.course.repositories;

import com.primeiroprojetospring.ProjetoSpring.course.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {

}

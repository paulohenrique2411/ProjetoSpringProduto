package com.primeiroprojetospring.ProjetoSpring.course.repositories;

import com.primeiroprojetospring.ProjetoSpring.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}

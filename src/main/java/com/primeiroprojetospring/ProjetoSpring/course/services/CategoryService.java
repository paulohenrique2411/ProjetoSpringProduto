package com.primeiroprojetospring.ProjetoSpring.course.services;

import com.primeiroprojetospring.ProjetoSpring.course.entities.Category;
import com.primeiroprojetospring.ProjetoSpring.course.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository CategoryRepository;

    public List<Category> findAll(){
        return CategoryRepository.findAll();
    }

    public Category findById(Long id){
        Optional<Category> obj =  CategoryRepository.findById(id);
        return obj.get();
    }
}

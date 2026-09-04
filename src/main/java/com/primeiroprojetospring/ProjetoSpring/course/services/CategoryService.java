package com.primeiroprojetospring.ProjetoSpring.course.services;

import com.primeiroprojetospring.ProjetoSpring.course.entities.Category;
import com.primeiroprojetospring.ProjetoSpring.course.repositories.CategoryRepository;
import com.primeiroprojetospring.ProjetoSpring.course.services.exceptions.DataIntegrityException;
import com.primeiroprojetospring.ProjetoSpring.course.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category findById(Long id){
        Optional<Category> obj =  categoryRepository.findById(id);
        return obj.get();
    }

    public Category insert( Category obj){
        categoryRepository.save(obj);
        return obj;
    }

    public void delete(Long id){
        try{
            if(categoryRepository.findById(id).isEmpty())
                throw new ResourceNotFoundException("Not have this category");

            if(!categoryRepository.getReferenceById(id).getProducts().isEmpty())
                throw new DataIntegrityException("Not possible, because the entity have correlation with others entities");

            categoryRepository.deleteById(id);
        } catch (DataIntegrityException e) {
            throw new DataIntegrityException(e.getMessage());
        }
    }
}

package com.primeiroprojetospring.ProjetoSpring.course.services;

import com.primeiroprojetospring.ProjetoSpring.course.entities.Product;
import com.primeiroprojetospring.ProjetoSpring.course.repositories.ProductRepository;
import com.primeiroprojetospring.ProjetoSpring.course.services.exceptions.IntegrityConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository ProductRepository;

    public List<Product> findAll(){
        return ProductRepository.findAll();
    }

    public Product findById(Long id){
        Optional<Product> obj =  ProductRepository.findById(id);
        return obj.get();
    }

    public Product insert(Product obj){
        try{
            List<Product> products = new ArrayList<>();
            products =  ProductRepository.findAll();
            if(products.stream().anyMatch(x -> x.getName().equals(obj.getName())))
                throw new IntegrityConstraintViolationException("Have other product with the same name");

            ProductRepository.save(obj);
            return obj;
        } catch (IntegrityConstraintViolationException e) {
            throw new IntegrityConstraintViolationException(e.getMessage());
        }

    }
}

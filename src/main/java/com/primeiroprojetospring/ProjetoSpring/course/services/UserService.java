package com.primeiroprojetospring.ProjetoSpring.course.services;

import com.primeiroprojetospring.ProjetoSpring.course.entities.User;
import com.primeiroprojetospring.ProjetoSpring.course.repositories.UserRepository;
import com.primeiroprojetospring.ProjetoSpring.course.services.exceptions.DataBaseException;
import com.primeiroprojetospring.ProjetoSpring.course.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService  {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        Optional<User> obj =  userRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void delete(Long id) {
        try{
            if(!userRepository.existsById(id)) throw new EmptyResultDataAccessException("Id not found for delete: " + id,0);
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(e.getMessage());
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException(e.getMessage());
        }
    }

    public User insert(User obj){
        return userRepository.save(obj);
    }

    public User update(Long id, User obj){
        try{
            if(!userRepository.existsById(id)) throw new EntityNotFoundException("This entity not exist : " + id);
            User entity = userRepository.getReferenceById(id);
            updateData(entity, obj);
            return userRepository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}

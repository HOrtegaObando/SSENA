package com.ke_detalles.SSENA.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ke_detalles.SSENA.dao.UserDao;
import com.ke_detalles.SSENA.entity.User;

@Service
public class Userservice {

    @Autowired
    private UserDao userRepository;

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
    
    public User findUserByAccount(String account) {
        //TO-DO implementar consulta tabla users por la columna username
        return null;
    }
    
    public User getUserAndPassword(User user) {
        return userRepository.findByUserAndPassword(user.getUsername(), user.getPassword());
    }

}
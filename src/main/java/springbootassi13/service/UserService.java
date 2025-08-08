package springbootassi13.service;

import springbootassi13.entity.User;
import springbootassi13.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService
{

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) 
    {
        return userRepository.findById(id);
    }

    public User createUser(User user) 
    {
        return userRepository.save(user);
    }

    public Optional<User> updateUser(Long id, User userDetails) 
    {
        return userRepository.findById(id).map(user -> {
            user.setName(userDetails.getName());
            user.setAge(userDetails.getAge());
            user.setSalary(userDetails.getSalary());
            return userRepository.save(user);
        });
    }

    public boolean deleteUser(Long id) 
    {
        return userRepository.findById(id).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);
    }
}
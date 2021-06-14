package project.demo.restoran.service;

import project.demo.restoran.model.auth.User;

import java.util.List;

public interface UserService {

    User findByUsername(String username);
    boolean save (User user);
//    List<User> getAllList();
//    void deleteById(int id);
}

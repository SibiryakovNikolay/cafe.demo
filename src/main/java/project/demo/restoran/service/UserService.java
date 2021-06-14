package project.demo.restoran.service;

import project.demo.restoran.model.auth.User;

public interface UserService {

    User findByUsername(String username);
}

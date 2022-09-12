package org.example.web.service;

import org.example.web.models.User;

import java.util.List;

public interface UserService {
    void save(User user);

    void update(User user);

    List<User> listAll();

    User getUser(long id);

    void deleteUser(long id);

}

package org.example.web.dao;

import org.example.web.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDaoSpringDataImpl extends UserDao, CrudRepository<User, Long> {
}

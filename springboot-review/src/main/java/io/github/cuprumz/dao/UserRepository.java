package io.github.cuprumz.dao;

import org.springframework.data.repository.CrudRepository;

import io.github.cuprumz.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    
}

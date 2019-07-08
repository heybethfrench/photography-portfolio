package com.bethfrench.photographyportfolio.models.dao;

import com.bethfrench.photographyportfolio.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Integer> {

    public User findByUsername(String username);

}

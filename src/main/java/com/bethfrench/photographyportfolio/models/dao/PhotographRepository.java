package com.bethfrench.photographyportfolio.models.dao;

import com.bethfrench.photographyportfolio.models.Photograph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.UUID;


    @Repository
    @Transactional
    public interface PhotographRepository extends CrudRepository<Photograph, UUID> {

    }


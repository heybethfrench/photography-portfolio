package com.bethfrench.photographyportfolio.config;

import com.bethfrench.photographyportfolio.models.MyGrantAuthority;
import com.bethfrench.photographyportfolio.models.User;
import com.bethfrench.photographyportfolio.models.dao.MyGrantAuthorityRepository;
import com.bethfrench.photographyportfolio.models.dao.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;


@SpringBootApplication
/*
@ComponentScan("com.bethfrench.photograph.models")
@ComponentScan("com.bethfrench.photograph.models.dao")
*/
public class SetupAdmin implements CommandLineRunner {

    private static Logger LOG = LoggerFactory
            .getLogger(SetupAdmin.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MyGrantAuthorityRepository myGrantAuthorityRepository;

    @Override
    public void run(String... args) {
        LOG.info("EXECUTING : Setting up initial admin user");

        MyGrantAuthority userRole = myGrantAuthorityRepository.getByRole("USER");
        if (userRole != null) {
            LOG.info("User role exists!");
        } else {
            userRole = new MyGrantAuthority("USER");
            myGrantAuthorityRepository.save(userRole);
        }


        MyGrantAuthority adminRole = myGrantAuthorityRepository.getByRole("ADMIN");
        if (adminRole != null) {
            LOG.info("Admin role exists!");
        } else {
            adminRole = new MyGrantAuthority("ADMIN");
            myGrantAuthorityRepository.save(adminRole);
            adminRole = myGrantAuthorityRepository.getByRole("ADMIN");
        }


        User admin = userRepository.findByUsername("admin@admin.com");

        if (admin != null) {
            LOG.info("Admin user exists, doing nothing...");
        } else {
            LOG.info("Creating new admin user");
            HashSet<MyGrantAuthority> grants = new HashSet<>();
            grants.add(adminRole);
            admin = new User("admin@admin.com", grants, "abc123", "504 boop street", "6186186186");
            userRepository.save(admin);
        }
    }
}
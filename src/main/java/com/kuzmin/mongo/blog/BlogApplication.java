package com.kuzmin.mongo.blog;

import com.kuzmin.mongo.blog.model.Blog;
import com.kuzmin.mongo.blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

@SpringBootApplication
public class BlogApplication {

    @Autowired
    private BlogRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }

    /*@Override
    public void run(String... args) throws Exception {
        // save a couple of customers
        repository.save(new Blog("1","Alice", "Smith", "sdsd", "sdf", Date.from(Instant.now()), Date.from(Instant.now())));
        repository.save(new Blog("2","Bob", "Smith", "ss", "dsd", Date.from(Instant.now()), Date.from(Instant.now())));

        // fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Blog customer : repository.findAll()) {
            System.out.println(customer);
        }
        System.out.println();
    }*/

}

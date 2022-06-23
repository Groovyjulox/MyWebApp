package com.example.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    public Long countById(Integer id);

    //Custom query
    @Query("SELECT p FROM User p WHERE "
            + "CONCAT(p.firstName,p.lastName,p.email)" + " LIKE %?1%")
    public List<User> findAll(String keyword);
}

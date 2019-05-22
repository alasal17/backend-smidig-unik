package com.westerdals.smidig.repository;


import com.westerdals.smidig.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends CrudRepository<User, Long> {


    User findByUserById(Long Id);

    @Override
    Iterable<User> findAll();
}


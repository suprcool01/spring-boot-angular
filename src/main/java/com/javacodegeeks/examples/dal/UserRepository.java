package com.javacodegeeks.examples.dal;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.javacodegeeks.examples.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}

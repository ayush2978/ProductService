package com.ayush.productservicespring.inheritanceExamples.joinedtable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User save(User user);
}

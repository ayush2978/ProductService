package com.ayush.productservicespring.inheritanceExamples.singletable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepositoryST")
public interface UserRepository extends JpaRepository<User,Long> {
    User save(User user);
}

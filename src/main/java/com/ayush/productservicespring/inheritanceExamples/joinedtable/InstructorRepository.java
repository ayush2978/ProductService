package com.ayush.productservicespring.inheritanceExamples.joinedtable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor,Long> {
    Instructor save(Instructor instructor);
}

package com.ayush.productservicespring.inheritanceExamples.singletable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("instructorRepositoryST")
public interface InstructorRepository extends JpaRepository<Instructor,Long> {
    Instructor save(Instructor instructor);
}

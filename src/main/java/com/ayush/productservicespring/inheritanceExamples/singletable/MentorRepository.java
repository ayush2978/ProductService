package com.ayush.productservicespring.inheritanceExamples.singletable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("mentorRepositoryST")
public interface MentorRepository extends JpaRepository<Mentor,Long> {
    Mentor save(Mentor mentor);
}

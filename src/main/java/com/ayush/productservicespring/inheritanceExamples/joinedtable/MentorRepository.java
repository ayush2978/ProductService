package com.ayush.productservicespring.inheritanceExamples.joinedtable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MentorRepository extends JpaRepository<Mentor,Long> {
    Mentor save(Mentor mentor);
}

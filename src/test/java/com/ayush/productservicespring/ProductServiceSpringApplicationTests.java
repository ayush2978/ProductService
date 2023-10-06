package com.ayush.productservicespring;

import com.ayush.productservicespring.inheritanceExamples.singletable.InstructorRepository;
import com.ayush.productservicespring.inheritanceExamples.singletable.MentorRepository;
import com.ayush.productservicespring.inheritanceExamples.singletable.UserRepository;
import com.ayush.productservicespring.inheritanceExamples.singletable.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductServiceSpringApplicationTests {

    @Autowired
    @Qualifier("userRepositoryST")
    UserRepository userRepository;

    @Autowired
    @Qualifier("mentorRepositoryST")
    MentorRepository mentorRepository;

    @Autowired
    @Qualifier("instructorRepositoryST")
    InstructorRepository instructorRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void test() {
        User user=new User();
        user.setEmail("ayush2978@gmail.com");
        user.setPassword("ayush");
        userRepository.save(user);

        Mentor mentor=new Mentor();
        mentor.setEmail("ayush@gmail.com");
        mentor.setPassword("ayush");
        mentor.setNumberOfSessions(123);
        mentor.setNumberOfAttendees(112);
        mentorRepository.save(mentor);

        Instructor instructor=new Instructor();
        instructor.setEmail("naman@gmail.com");
        instructor.setPassword("naman");
        instructorRepository.save(instructor);


    }
}

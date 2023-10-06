package com.ayush.productservicespring.inheritanceExamples.singletable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_mentor")
public class Mentor extends User {
    private int numberOfSessions;
    private int numberOfAttendees;
}

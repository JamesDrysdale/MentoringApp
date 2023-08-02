package com.codeclan.mentoring.mentoringservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="mentors")
public class Mentor extends Mentee {

    @JsonIgnoreProperties({"mentors"})
    @ManyToMany
    @JoinTable(
            name = "mentor_mentee",
            joinColumns = {@JoinColumn(
                    name = "mentor_id",
                    nullable = false,
                    updatable = false
            )},
            inverseJoinColumns = {@JoinColumn(
                    name = "mentee_id",
                    nullable = false,
                    updatable = false
            )}
    )

    private List<Mentee> mentees;

    public Mentor(String fullName, String email, String bio, String linkedIn) {
        super(fullName, email, bio, linkedIn);
        this.mentees = new ArrayList<>();
    }

    public Mentor() {};

    public List<Mentee> getMentees() {
        return mentees;
    }

    public void acceptMentee(Mentee mentee) {
        mentees.add(mentee);
    }
}

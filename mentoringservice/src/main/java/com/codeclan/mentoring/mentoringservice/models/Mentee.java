package com.codeclan.mentoring.mentoringservice.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name="mentees")
public class Mentee extends Member {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "mentee_id")
//    private Long menteeId;

    @ManyToMany
    @JoinTable(
            name = "mentor_mentee",
            joinColumns = {@JoinColumn(
                    name = "mentee_id",
                    nullable = false,
                    updatable = false
            )},
            inverseJoinColumns = {@JoinColumn(
                    name = "mentor_id",
                    nullable = false,
                    updatable = false
            )}
    )
    private List<Mentor> mentors;

    public Mentee(String fullName, String email, String bio, String linkedIn) {
        super(fullName, email, bio, linkedIn);
        this.mentors = new ArrayList<>();
    }

    public Mentee() {};

    public List<Mentor> getMentors() {
        return mentors;
    }
}

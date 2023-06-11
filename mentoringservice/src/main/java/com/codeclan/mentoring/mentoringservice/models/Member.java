package com.codeclan.mentoring.mentoringservice.models;

import jakarta.persistence.*;

@Entity
@Table(name="members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="full_name")
    private String fullName;

    @Column(name="bio")
    private String bio;

    @Column(name="linkedin")
    private String linkedIn;

    public Member(String fullName, String bio, String linkedIn) {
        this.fullName = fullName;
        this.bio = bio;
        this.linkedIn = linkedIn;
    }

    public Member () {}

    public Long getId() {
        return id;
    }

    public void setId(Long newId) {
        this.id = newId;
    }

    public String getName() {
        return fullName;
    }

    public void setName(String newName) {
        fullName = newName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String newBio) {
        bio = newBio;
    }

    public String getLinkedIn() {
        return  linkedIn;
    }

    public void setLinkedIn(String newLinkedIn) {
        linkedIn = newLinkedIn;
    }
}

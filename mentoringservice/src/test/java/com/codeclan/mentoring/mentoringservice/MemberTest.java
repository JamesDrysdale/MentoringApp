package com.codeclan.mentoring.mentoringservice;

import com.codeclan.mentoring.mentoringservice.models.Member;
import com.codeclan.mentoring.mentoringservice.models.Mentor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MemberTest {
    Member mentee;
    Member mentor;

    @Before
    public void setUp() {
        mentee = new Member("Dave McKenzie", "dave@mail.com", "I am a Product Owner with an extensive background in QA testing", "/in/dave-mckenzie/", false);
        mentor = new Mentor("James", "james@email.com", "Instructor and mentor", "/in/james", true);
    }

    @Test
    public void memberHasAName() {
        assertEquals("Dave McKenzie", mentee.getName());
    }

    @Test
    public void canUpdateMemberName() {
        mentee.setName("Neil");
        assertEquals("Neil", mentee.getName());
    }

    @Test
    public void memberHasAnEmail() {
        assertEquals("dave@mail.com", mentee.getEmail());
    }

    @Test
    public void memberCanUpdateEmail() {
        mentee.setEmail("davec@email.com");
        assertEquals("davec@email.com", mentee.getEmail());
    }

    @Test
    public void memberHasABio() {
        assertEquals("I am a Product Owner with an extensive background in QA testing", mentee.getBio());
    }

    @Test
    public void canUpdateBio() {
        mentee.setBio("Product Owner");
        assertEquals("Product Owner", mentee.getBio());
    }

    @Test
    public void memberHasALinkedInLink() {
        assertEquals("/in/dave-mckenzie/", mentee.getLinkedIn());
    }

    @Test
    public void canUpdateLinkedIn() {
        mentee.setLinkedIn("/in/neil-mckenzie");
        assertEquals("/in/neil-mckenzie", mentee.getLinkedIn());
    }

    @Test
    public void memberCanBeMenteeButNotMentor() {
        assertEquals(false, mentee.getMentorStatus());
    }
}

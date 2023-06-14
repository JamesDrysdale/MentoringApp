package com.codeclan.mentoring.mentoringservice;

import com.codeclan.mentoring.mentoringservice.models.Mentor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MentorTest {

    Mentor james;

    @Before
    public void setUp() {
        james = new Mentor("James Drysdale", "james@email.com", "Software development instructor", "/in/james-drysdale", true);
    }

    @Test
    public void MentorHasAName() {
        assertEquals("James Drysdale", james.getName());
    }

    @Test
    public void canSetMentorName() {
        james.setName("Martin");
        assertEquals("Martin", james.getName());
    }

    @Test
    public void MentorHasAnEmail() {
        assertEquals("james@email.com", james.getEmail());
    }

    @Test
    public void canSetMentorEmail() {
        james.setEmail("jamesd@mail.com");
        assertEquals("jamesd@mail.com", james.getEmail());
    }

    @Test
    public void MentorHasBio() {
        assertEquals("Software development instructor", james.getBio());
    }

    @Test
    public void canSetMentorBio() {
        james.setBio("Developer");
        assertEquals("Developer", james.getBio());
    }

    @Test
    public void MentorHasLinkedIn() {
        assertEquals("/in/james-drysdale", james.getLinkedIn());
    }

    @Test
    public void canSetMentorLinkedIn() {
        james.setLinkedIn("/in/jd");
        assertEquals("/in/jd", james.getLinkedIn());
    }

    @Test
    public void memberCanBeAMentor(){
        assertEquals(true, james.getMentorStatus());
    }

}

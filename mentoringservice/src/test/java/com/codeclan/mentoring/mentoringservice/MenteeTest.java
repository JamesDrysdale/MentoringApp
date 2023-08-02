package com.codeclan.mentoring.mentoringservice;

import com.codeclan.mentoring.mentoringservice.models.Mentee;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MenteeTest {

    Mentee james;

    @Before
    public void setUp() {
        james = new Mentee("James Drysdale", "james@email.com", "Software development instructor", "/in/james-drysdale");
    }

    @Test
    public void MenteeHasAName() {
        assertEquals("James Drysdale", james.getName());
    }

    @Test
    public void canSetMenteeName() {
        james.setName("Martin");
        assertEquals("Martin", james.getName());
    }

    @Test
    public void MenteeHasAnEmail() {
        assertEquals("james@email.com", james.getEmail());
    }

    @Test
    public void canSetMenteeEmail() {
        james.setEmail("jamesd@mail.com");
        assertEquals("jamesd@mail.com", james.getEmail());
    }

    @Test
    public void MenteeHasBio() {
        assertEquals("Software development instructor", james.getBio());
    }

    @Test
    public void canSetMenteeBio() {
        james.setBio("Developer");
        assertEquals("Developer", james.getBio());
    }

    @Test
    public void MenteeHasLinkedIn() {
        assertEquals("/in/james-drysdale", james.getLinkedIn());
    }

    @Test
    public void canSetMenteeLinkedIn() {
        james.setLinkedIn("/in/jd");
        assertEquals("/in/jd", james.getLinkedIn());
    }
}

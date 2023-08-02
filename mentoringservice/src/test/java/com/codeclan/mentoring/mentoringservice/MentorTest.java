package com.codeclan.mentoring.mentoringservice;

import com.codeclan.mentoring.mentoringservice.models.Mentee;
import com.codeclan.mentoring.mentoringservice.models.Mentor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MentorTest {

    Mentor james;

    @Before
    public void setUp() {
        james = new Mentor("James Drysdale", "james@email.com", "Software development instructor", "/in/james-drysdale");
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
    public void mentorStartsOffwith0Mentees() {
        assertEquals(0, james.getMentees().size());
    }

    @Test
    public void mentorCanAcceptMenteeRequest() {
        Mentee mentee1 = new Mentee("John Doe", "john@example.com", "Aspiring Developer", "/in/john-doe");
        james.acceptMentee(mentee1);

        // After accepting a mentee, the size of the mentor's mentee list should be 1
        assertEquals(1, james.getMentees().size());

        // Verify that the correct mentee was added to the list
        assertEquals(mentee1, james.getMentees().get(0));
    }


}

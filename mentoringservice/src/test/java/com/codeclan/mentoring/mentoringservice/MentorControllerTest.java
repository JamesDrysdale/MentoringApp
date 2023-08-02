package com.codeclan.mentoring.mentoringservice;

import com.codeclan.mentoring.mentoringservice.controllers.MentorController;
import com.codeclan.mentoring.mentoringservice.models.Mentor;
import com.codeclan.mentoring.mentoringservice.repositories.MentorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MentorController.class)
public class MentorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MentorRepository mentorRepository;

    @Test
    public void testGetAllMentors() throws Exception {
        // Create some sample mentors for testing
        Mentor mentor1 = new Mentor("Stacy", "stacy@email.com", "Yoga Guru", "/in/stacy");
        Mentor mentor2 = new Mentor("Jen", "jen@email.com", "Java Master", "/in/jen");

        // Mock the behavior of the MentorRepository
        List<Mentor> mockMentors = Arrays.asList(mentor1, mentor2);
        when(mentorRepository.findAll()).thenReturn(mockMentors);

        // Perform the GET request to the controller's endpoint
        mockMvc.perform(get("/mentors"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("Stacy"))
                .andExpect(jsonPath("$[0].email").value("stacy@email.com"))
                .andExpect(jsonPath("$[1].name").value("Jen"))
                .andExpect(jsonPath("$[1].email").value("jen@email.com"));
    }
}

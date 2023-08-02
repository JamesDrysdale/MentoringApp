package com.codeclan.mentoring.mentoringservice;

import com.codeclan.mentoring.mentoringservice.models.Mentor;
import com.codeclan.mentoring.mentoringservice.repositories.MentorRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class MentorRepositoryTest {

    @Autowired
    MentorRepository mentorRepository;

//    @Test
//    public void contextLoads() {
        //ONLY used to clear the DB for testing purposes. Do not use in production code
//        mentorRepository.deleteAll();
//    }

    @Test
    public void createSingleMentorAndSave() {
        Mentor mentor1 = new Mentor("Claire", "claire@email.com", "Marketing Expert", "/in/claire");
        mentorRepository.save(mentor1);
    }

    @Test
    public void createMultipleMentorsAndSave() {
        Mentor mentor1 = new Mentor("Stacy", "stacy@email.com", "Yoga Mentor", "/in/stacy");
        mentorRepository.save(mentor1);
        Mentor mentor2 = new Mentor("George", "george@email.com", "UX Mentor", "/in/george");
        mentorRepository.save(mentor2);
    }

}

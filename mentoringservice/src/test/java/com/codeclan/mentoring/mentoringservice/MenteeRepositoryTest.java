package com.codeclan.mentoring.mentoringservice;

import com.codeclan.mentoring.mentoringservice.models.Mentee;
import com.codeclan.mentoring.mentoringservice.repositories.MenteeRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class MenteeRepositoryTest {

    @Autowired
    MenteeRepository menteeRepository;

//    @Test
//    public void contextLoads() {
//        // ONLY used to clear the DB for testing purposes. Do not use in production code
//        menteeRepository.deleteAll();
//    }

//    @Test
//    public void createSingleMenteeAndSave() {
//        Mentee mentee1 = new Mentee("James", "james@coding.com", "Instructor", "/in/James");
//        menteeRepository.save(mentee1);
//    }

    @Test
    public void createMultipleMenteesAndSave() {
        Mentee mentee1 = new Mentee("Scout", "scout@email.com", "Student Sound Designer", "/in/stacy");
        menteeRepository.save(mentee1);
        Mentee mentee2 = new Mentee("Jerry", "jerry@email.com", "Data Analysis student", "/in/george");
        menteeRepository.save(mentee2);
    }
}

package com.codeclan.mentoring.mentoringservice.components;

import com.codeclan.mentoring.mentoringservice.models.Mentee;
import com.codeclan.mentoring.mentoringservice.models.Mentor;
import com.codeclan.mentoring.mentoringservice.repositories.MenteeRepository;
import com.codeclan.mentoring.mentoringservice.repositories.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!test")
@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    MentorRepository mentorRepository;

    @Autowired
    MenteeRepository menteeRepository;

    public DataLoader(){};

    public  void run(ApplicationArguments args) {
//        Mentor mentor1 = new Mentor("Stacy", "stacy@email.com", "Yoga Mentor", "/in/stacy");
//        mentorRepository.save(mentor1);
//        Mentor mentor2 = new Mentor("George", "george@email.com", "UX Mentor", "/in/george");
//        mentorRepository.save(mentor2);
//        Mentor mentor3 = new Mentor("James Drysdale", "james@email.com", "Software development instructor", "/in/james-drysdale");
//        mentorRepository.save(mentor3);
//
//        Mentee mentee1 = new Mentee("Scout", "scout@email.com", "Student Sound Designer", "/in/stacy");
//        menteeRepository.save(mentee1);
//        Mentee mentee2 = new Mentee("Jerry", "jerry@email.com", "Data Analysis student", "/in/george");
//        menteeRepository.save(mentee2);
//        Mentee mentee3 = new Mentee("Alex", "alex@email.com", "Software Development student", "/in/alex");
//        menteeRepository.save(mentee3);

//        mentor3.acceptMentee(mentee1);
//        mentorRepository.save(mentor3);
//
//        System.out.println(mentor3.getMentees());

    }
}

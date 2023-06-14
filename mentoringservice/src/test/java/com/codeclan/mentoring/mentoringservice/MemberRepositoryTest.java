package com.codeclan.mentoring.mentoringservice;

import com.codeclan.mentoring.mentoringservice.models.Member;
import com.codeclan.mentoring.mentoringservice.models.Mentor;
import com.codeclan.mentoring.mentoringservice.repositories.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

//    @Test
//    public void contextLoads() {
//        //ONLY used to clear the DB for testing purposes. Do not use in production code
//        memberRepository.deleteAll();
//    }

    @Test
    public void createSingleMenteeAndSave() {
        Member mentee = new Member("Claire", "claire@email.com", "Marketing Expert", "/in/claire", false);
        memberRepository.save(mentee);
    }

    @Test
    public void createSingleMentorAndSave() {
        Member mentor = new Member("James Drysdale", "james@email.com", "Software development instructor", "/in/james-drysdale", true);
        memberRepository.save(mentor);
    }
}

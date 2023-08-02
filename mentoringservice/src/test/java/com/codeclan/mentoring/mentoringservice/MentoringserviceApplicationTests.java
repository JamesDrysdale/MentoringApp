package com.codeclan.mentoring.mentoringservice;

import com.codeclan.mentoring.mentoringservice.models.Member;
import com.codeclan.mentoring.mentoringservice.models.Mentor;
import com.codeclan.mentoring.mentoringservice.repositories.MentorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MentoringserviceApplicationTests {

	@Autowired
	MentorRepository mentorRepository;



	@Test
	void contextLoads() {
		mentorRepository.deleteAll();
	}

    @Test
	public void canAddMentorAndSave() {
		Mentor mentor = new Mentor("James", "james@email.com", "Instructor", "/in/james");
		mentorRepository.save(mentor);
	}

}

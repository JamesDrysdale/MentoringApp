package com.codeclan.mentoring.mentoringservice.repositories;

import com.codeclan.mentoring.mentoringservice.models.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, Long> {

}

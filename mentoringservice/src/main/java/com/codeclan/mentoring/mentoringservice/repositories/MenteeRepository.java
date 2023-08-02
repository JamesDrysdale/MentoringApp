package com.codeclan.mentoring.mentoringservice.repositories;

import com.codeclan.mentoring.mentoringservice.models.Mentee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenteeRepository extends JpaRepository<Mentee, Long> {
}

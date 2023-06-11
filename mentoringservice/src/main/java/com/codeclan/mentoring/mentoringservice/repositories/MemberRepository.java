package com.codeclan.mentoring.mentoringservice.repositories;
import com.codeclan.mentoring.mentoringservice.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

}

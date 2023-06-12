package com.codeclan.mentoring.mentoringservice.controllers;

import com.codeclan.mentoring.mentoringservice.models.Member;
import com.codeclan.mentoring.mentoringservice.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class MemberController {

    @Autowired
    MemberRepository memberRepository;

    @GetMapping(value = "/members")
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @GetMapping(value = "/members/id/{id}")
    public Optional<Member> getMemberById(@PathVariable Long id) {
        return memberRepository.findById(id);
    }

    @GetMapping("/members/email/{email}")
    public ResponseEntity<Member> getMemberByEmail(@PathVariable String email) {
        Optional<Member> optionalMember = memberRepository.findByEmail(email);

        if (optionalMember.isPresent()) {
            Member member = optionalMember.get();
            return ResponseEntity.ok(member);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}

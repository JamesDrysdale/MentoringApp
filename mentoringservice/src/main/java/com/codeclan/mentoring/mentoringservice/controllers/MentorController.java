package com.codeclan.mentoring.mentoringservice.controllers;

import com.codeclan.mentoring.mentoringservice.models.Mentee;
import com.codeclan.mentoring.mentoringservice.models.Mentor;
import com.codeclan.mentoring.mentoringservice.repositories.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MentorController {

    @Autowired
    MentorRepository mentorRepository;

    // GET a list of all the mentors
    @GetMapping(value = "/mentors")
    public ResponseEntity<List<Mentor>> getAllMentors(){
        return new ResponseEntity<>(mentorRepository.findAll(), HttpStatus.OK);
    }

    // GET the mentor with the given ID
    @GetMapping(value = "/mentors/{id}")
    public ResponseEntity<Mentor> getMentor(@PathVariable Long id) {
        // Check if the mentor with the given ID exists in the database
        Optional<Mentor> mentorOptional = mentorRepository.findById(id);

        if (mentorOptional.isPresent()) {
            // If the mentor exists, return it in the response
            Mentor mentor = mentorOptional.get();
            return ResponseEntity.ok(mentor);
        } else {
            // If the mentor with the given ID does not exist, return 404 Not Found
            return ResponseEntity.notFound().build();
        }
    }

    // GET a list of a specific mentor's mentees
    @GetMapping(value = "/mentors/{id}/mentees")
    public ResponseEntity<List<Mentee>> getMenteesByMentorId(@PathVariable("id") Long mentorId) {
        // Check if the mentor with the given ID exists in the database
        Optional<Mentor> mentorOptional = mentorRepository.findById(mentorId);

        if (mentorOptional.isPresent()) {
            Mentor mentor = mentorOptional.get();
            List<Mentee> mentees = mentor.getMentees();

            // Return the list of mentees associated with the mentor in the response
            return ResponseEntity.ok(mentees);
        } else {
            // If the mentor with the given ID does not exist, return 404 Not Found
            return ResponseEntity.notFound().build();
        }
    }

    // CREATE a new mentor and save to the database
    @PostMapping(value = "/mentors")
    public ResponseEntity postMentor(@RequestBody Mentor mentor) {
        mentorRepository.save(mentor);
        return new ResponseEntity<>(mentor, HttpStatus.CREATED);
    }

    // UPDATE an existing mentor
    @PutMapping(value = "/mentors/{id}")
    public ResponseEntity<Mentor> updateMentor(@PathVariable("id") Long id, @RequestBody Mentor mentor) {
        // Check if the mentor with the given ID exists in the database
        Optional<Mentor> existingMentorOptional = mentorRepository.findById(id);

        if (existingMentorOptional.isPresent()) {
            Mentor existingMentor = existingMentorOptional.get();

            // Update the attributes of the existing mentor with the values from the input mentor
            existingMentor.setName(mentor.getName());
            existingMentor.setEmail(mentor.getEmail());
            existingMentor.setBio(mentor.getBio());
            existingMentor.setLinkedIn(mentor.getLinkedIn());

            // Save the updated mentor back to the database
            Mentor updatedMentor = mentorRepository.save(existingMentor);

            // Return the updated mentor in the response
            return ResponseEntity.ok(updatedMentor);
        } else {
            // If the mentor with the given ID does not exist, return 404 Not Found
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE a mentor with a given id
    @DeleteMapping(value = "/mentors/{id}")
    public ResponseEntity<Void> deleteMentor(@PathVariable("id") Long id) {
        // Check if the mentor with the given ID exists in the database
        Optional<Mentor> existingMentorOptional = mentorRepository.findById(id);

        if (existingMentorOptional.isPresent()) {
            Mentor existingMentor = existingMentorOptional.get();

            // Delete the mentor from the database
            mentorRepository.delete(existingMentor);

            // Return 200 OK response to indicate successful deletion
            return ResponseEntity.ok().build();
        } else {
            // If the mentor with the given ID does not exist, return 404 Not Found
            return ResponseEntity.notFound().build();
        }
    }
}

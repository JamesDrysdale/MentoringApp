package com.codeclan.mentoring.mentoringservice.controllers;

import com.codeclan.mentoring.mentoringservice.models.Mentee;
import com.codeclan.mentoring.mentoringservice.models.Mentor;
import com.codeclan.mentoring.mentoringservice.repositories.MenteeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MenteeController {

    @Autowired
    MenteeRepository menteeRepository;

    // GET a list of all the mentees
    @GetMapping(value = "/mentees")
    public ResponseEntity<List<Mentee>> getAllMentees(){
        return new ResponseEntity<>(menteeRepository.findAll(), HttpStatus.OK);
    }

    // GET the mentee with the given ID
    @GetMapping(value = "/mentees/{id}")
    public ResponseEntity<Mentee> getMentee(@PathVariable Long id) {
        // Check if the mentee with the given ID exists in the database
        Optional<Mentee> menteeOptional = menteeRepository.findById(id);

        if (menteeOptional.isPresent()) {
            // If the mentee exists, return it in the response
            Mentee mentee = menteeOptional.get();
            return ResponseEntity.ok(mentee);
        } else {
            // If the mentee with the given ID does not exist, return 404 Not Found
            return ResponseEntity.notFound().build();
        }
    }

    // GET a list of a specific mentee's mentors
    @GetMapping(value = "/mentees/{id}/mentors")
    public ResponseEntity<List<Mentor>> getMentorsByMenteeId(@PathVariable("id") Long menteeId) {
        // Check if the mentee with the given ID exists in the database
       Optional<Mentee> menteeOptional = menteeRepository.findById(menteeId);

        if (menteeOptional.isPresent()) {
            Mentee mentee = menteeOptional.get();
            List<Mentor> mentors = mentee.getMentors();

           // Return the list of mentors associated with the mentee in the response
            return ResponseEntity.ok(mentors);
        } else {
            // If the mentee with the given ID does not exist, return 404 Not Found
           return ResponseEntity.notFound().build();
        }
    }

    // CREATE a new mentee and save to the database
    @PostMapping(value = "/mentees")
    public ResponseEntity postMentee(@RequestBody Mentee mentee) {
        menteeRepository.save(mentee);
        return new ResponseEntity<>(mentee, HttpStatus.CREATED);
    }

    // UPDATE an existing mentee
    @PutMapping(value = "/mentees/{id}")
    public ResponseEntity<Mentee> updateMentee(@PathVariable("id") Long id, @RequestBody Mentee mentee) {
        // Check if the mentee with the given ID exists in the database
        Optional<Mentee> existingMenteeOptional = menteeRepository.findById(id);

        if (existingMenteeOptional.isPresent()) {
            Mentee existingMentee = existingMenteeOptional.get();

            // Update the attributes of the existing mentee with the values from the input mentee
            existingMentee.setName(mentee.getName());
            existingMentee.setEmail(mentee.getEmail());
           existingMentee.setBio(mentee.getBio());
           existingMentee.setLinkedIn(mentee.getLinkedIn());

           // Save the updated mentee back to the database
           Mentee updatedMentee = menteeRepository.save(existingMentee);

            // Return the updated mentee in the response
            return ResponseEntity.ok(updatedMentee);
        } else {
            // If the mentee with the given ID does not exist, return 404 Not Found
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE a mentee with a given id
    @DeleteMapping(value = "/mentees/{id}")
    public ResponseEntity<Void> deleteMentee(@PathVariable("id") Long id) {
        // Check if the mentee with the given ID exists in the database
        Optional<Mentee> existingMenteeOptional = menteeRepository.findById(id);

        if (existingMenteeOptional.isPresent()) {
            Mentee existingMentee = existingMenteeOptional.get();

            // Delete the mentee from the database
            menteeRepository.delete(existingMentee);

           // Return 200 OK response to indicate successful deletion
            return ResponseEntity.ok().build();
        } else {
            // If the mentee with the given ID does not exist, return 404 Not Found
            return ResponseEntity.notFound().build();
        }
    }
}

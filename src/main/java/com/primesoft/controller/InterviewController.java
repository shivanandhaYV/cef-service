package com.primesoft.controller;


import com.primesoft.dto.CandidateDetailDto;
import com.primesoft.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/interview")
public class InterviewController {

    @Autowired
    private InterviewService interviewService;

    @PostMapping
    public ResponseEntity<CandidateDetailDto> saveCandidateDetails(@RequestBody CandidateDetailDto candidateDetail){
        return ResponseEntity.status(HttpStatus.CREATED).body(interviewService.saveCandidateDetails(candidateDetail));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CandidateDetailDto> getCandidateDetailsById(@PathVariable UUID id){
        return ResponseEntity.ok().body(interviewService.getCandidateDetails(id));
    }

    @PatchMapping
    public ResponseEntity<String> updateCandidate(@RequestBody CandidateDetailDto candidateDetail){
        return ResponseEntity.accepted().body(interviewService.updateCandidateDetails(candidateDetail));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCandidateDetails(@PathVariable UUID id){
        return ResponseEntity.ok().body(interviewService.deleteCandidateDetails(id));
    }


}

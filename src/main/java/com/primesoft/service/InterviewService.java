package com.primesoft.service;

import com.primesoft.dto.CandidateDetailDto;

import java.util.UUID;

public interface InterviewService {

    CandidateDetailDto saveCandidateDetails(CandidateDetailDto candidateDetail);

    CandidateDetailDto getCandidateDetails(UUID id);

    String updateCandidateDetails(CandidateDetailDto candidateDetail);

    String deleteCandidateDetails(UUID id);
}

package com.primesoft.repo;

import com.primesoft.entity.InterviewRound;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InterviewRoundRepository extends JpaRepository<InterviewRound, UUID> {
}

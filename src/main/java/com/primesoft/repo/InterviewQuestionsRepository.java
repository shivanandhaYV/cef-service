package com.primesoft.repo;

import com.primesoft.entity.InterviewQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InterviewQuestionsRepository extends JpaRepository<InterviewQuestion, UUID> {
}

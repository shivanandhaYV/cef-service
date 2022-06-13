package com.primesoft.repo;

import com.primesoft.entity.CandidateDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CandidateRepository extends JpaRepository<CandidateDetail, UUID> {
}

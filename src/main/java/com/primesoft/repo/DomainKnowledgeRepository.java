package com.primesoft.repo;

import com.primesoft.entity.DomainKnowledge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DomainKnowledgeRepository extends JpaRepository<DomainKnowledge, UUID> {
    List<DomainKnowledge> findByCandidateDetailId(UUID id);
}

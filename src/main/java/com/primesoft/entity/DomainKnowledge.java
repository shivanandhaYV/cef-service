package com.primesoft.entity;

import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Table(name = "domain_knowledge")
public class DomainKnowledge {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "skill", nullable = false)
    private String skill;



    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Lob
    @Column(name = "created_by", nullable = false)
    private String createdBy;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @Lob
    @Column(name = "updated_by")
    private String updatedBy;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "candidate_id", nullable = false)
    private CandidateDetail candidateDetail;


}
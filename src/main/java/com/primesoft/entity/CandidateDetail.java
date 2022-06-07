package com.primesoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "candidate_details")
@Setter
@Getter
public class CandidateDetail {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "candidate_name", nullable = false)
    private String candidateName;

    @Lob
    @Column(name = "email", nullable = false)
    private String email;

    @Lob
    @Column(name = "mobile", nullable = false)
    private String mobile;

    @Column(name = "job_id", nullable = false)
    private Integer jobId;

    @Lob
    @Column(name = "communication_skills", nullable = false)
    private String communicationSkills;

    @Lob
    @Column(name = "domain_knowldge")
    private String domainKnowldge;

    @Lob
    @Column(name = "collaboration_skills", nullable = false)
    private String collaborationSkills;

    @Lob
    @Column(name = "culture_fit", nullable = false)
    private String cultureFit;

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


    @OneToMany(mappedBy = "candidateDetail", orphanRemoval = true)
    private List<DomainKnowledge> domainKnowledges;

    @OneToMany(mappedBy = "candidateDetail", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InterviewRound> interviewRounds;

}
package com.primesoft.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "interview_round")
public class InterviewRound {
    @Id
    @Column(name = "round_id", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "round_no", nullable = false)
    private String roundNo;

    @Column(name = "rating", precision = 131089)
    private BigDecimal rating;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "interviewed_by")
    private Employee employee;

    @Lob
    @Column(name = "is_selected", nullable = false)
    private char isSelected;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Lob
    @Column(name = "created_by", nullable = false)
    private String createdBy;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Lob
    @Column(name = "updated_by")
    private String updatedBy;

    @OneToMany(mappedBy = "interviewRound")
    private List<InterviewQuestion> interviewQuestions;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "candidate_id")
    private CandidateDetail candidateDetail;

}
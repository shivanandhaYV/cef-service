package com.primesoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "interview_questions")
@Setter
@Getter
public class InterviewQuestion {
    @Id
    @Column(name = "question_id", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "question_name", nullable = false)
    private String questionName;

    @Lob
    @Column(name = "feedback", nullable = false)
    private String feedback;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "iterview_round_no")
    private InterviewRound interviewRound;

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

}
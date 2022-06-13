package com.primesoft.entity;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "interview_round")
public class InterviewRound {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator",
            parameters = {
                    @Parameter(
                            name = "uuid_gen_strategy_class",
                            value = "org.hibernate.id.uuid.CustomVersionOneStrategy"
                    )
            }
    )
    @Column(name = "round_id", nullable = false)
    private UUID id;

    @Column(name = "round_no", nullable = false)
    private String roundNo;

    @Column(name = "rating", precision = 131089)
    private BigDecimal rating;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "interviewed_by")
    private Employee employee;


    @Column(name = "is_selected", nullable = false)
    private char isSelected;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;


    @Column(name = "created_by", nullable = false)
    private String createdBy;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


    @Column(name = "updated_by")
    private String updatedBy;

    @OneToMany(mappedBy = "interviewRound",orphanRemoval = true)
    private List<InterviewQuestion> interviewQuestions;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "candidate_id")
    private CandidateDetail candidateDetail;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getRoundNo() {
        return roundNo;
    }

    public void setRoundNo(String roundNo) {
        this.roundNo = roundNo;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public char getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(char isSelected) {
        this.isSelected = isSelected;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public List<InterviewQuestion> getInterviewQuestions() {
        return interviewQuestions;
    }

    public void setInterviewQuestions(List<InterviewQuestion> interviewQuestions) {
        this.interviewQuestions = interviewQuestions;
    }

    public CandidateDetail getCandidateDetail() {
        return candidateDetail;
    }

    public void setCandidateDetail(CandidateDetail candidateDetail) {
        this.candidateDetail = candidateDetail;
    }
}